package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MatchingRepository;
import pairmatching.util.RandomShuffle;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MatchingService {
    private CrewRepository crewRepository = new CrewRepository();
    private RandomShuffle randomShuffle = new RandomShuffle();
    private MatchingRepository matchingRepository = new MatchingRepository();

    public boolean hasPair(Mission mission) {
        return matchingRepository.hasPair(mission);
    }

    public void matchPair(Mission mission) {
        if (mission.isBackendCourse()) {
            matchCheck(mission, crewRepository.getBackendCrews());
            return;
        }
        matchCheck(mission, crewRepository.getFrontendCrews());
    }

    private void matchCheck(Mission mission, List<String> crews) {
        boolean isSuccess = false;
        for (int i = 0; i < 3; i++) {
            List<Crew> randomOrder = getRandomOrder(crews);
            if (!matchingRepository.hasSameLevelSamePair(mission, randomOrder)) {
                saveMatchResult(mission, randomOrder);
                isSuccess = true;
            }
        }
        if (!isSuccess) {
            throw new IllegalArgumentException("매칭할 수 없습니다.");
        }
    }

    private void saveMatchResult(Mission mission, List<Crew> randomOrder) {
        List<Pair> pairs = createPair(randomOrder);
        matchingRepository.addMatchingResult(mission, pairs);
    }

    public List<Pair> createPair(List<Crew> randomOrder) {
        if (randomOrder.size() % 2 == 0) {
            return createPairEven(randomOrder);
        }
        return createPairOdd(randomOrder);
    }
    private List<Pair> createPairEven(List<Crew> randomOrder) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i < randomOrder.size(); i += 2) {
            pairs.add(Pair.of(randomOrder.subList(i, i+2)));
        }
        return pairs;
    }

    private List<Pair> createPairOdd(List<Crew> randomOrder) {
        List<Pair> pairs = createPairEven(randomOrder.subList(0, randomOrder.size()-3));
        pairs.add(Pair.of(randomOrder.subList(randomOrder.size()-3, randomOrder.size())));
        return pairs;
    }
    public List<Crew> getRandomOrder(List<String> crews) {
        return randomShuffle.getRandomOrder(crews).stream()
                .map(name -> Crew.of(Course.BACKEND, name))
                .collect(Collectors.toList());
    }

    public List<Pair> getMatchResult(Mission mission) {
        return matchingRepository.findByMission(mission);
    }

    public void resetPairMatching(){
        matchingRepository.resetPairMatching();
    }
}
