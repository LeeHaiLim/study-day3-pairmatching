package pairmatching.service;

import pairmatching.domain.Crew;
import pairmatching.domain.MissionGroup;
import pairmatching.domain.Pair;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MatchingRepository;
import pairmatching.util.RandomPairMaker;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class MatchingService {
    private CrewRepository crewRepository = new CrewRepository();
    private MatchingRepository matchingRepository = new MatchingRepository();

    public List<Pair> matchPairs(MissionGroup missionGroup) {
        List<String> crews = crewRepository.getCrewsByCourse(missionGroup.getCourse());
        if (crews.size() < 2) {
            throw new IllegalArgumentException("2명 이상일 때 매칭할 수 있습니다.");
        }
        if (matchingRepository.getSameLevelPairs(missionGroup).isEmpty()) {
            return getRandomOrder(missionGroup, crews);
        }
        return getValidMatchingPairs(missionGroup, crews);
    }

    private List<Pair> getValidMatchingPairs(MissionGroup missionGroup, List<String> crews) {
        for (int i = 0; i < 3; i++) {
            List<Pair> randomOrder = getRandomOrder(missionGroup, crews);
            List<Pair> repositoryPairs = matchingRepository.getSameLevelPairs(missionGroup).get();
            if (!hasSamePair(randomOrder, repositoryPairs)) {
                return randomOrder;
            }
        }
        throw new IllegalArgumentException("매칭할 수 없습니다.");
    }

    private List<Pair> getRandomOrder(MissionGroup missionGroup, List<String> crews) {
        return convertToPair(RandomPairMaker.getRandomOrder(crews).stream()
                .map(name -> Crew.of(missionGroup.getCourse(), name))
                .collect(Collectors.toList()));
    }

    private boolean hasSamePair(List<Pair> randomOrder, List<Pair> pairs) {
        return randomOrder.stream()
                .anyMatch(randomPair -> pairs.stream()
                        .anyMatch(pair -> pair.isSamePair(randomPair)));
    }

    private List<Pair> convertToPair(List<Crew> crews) {
        List<Pair> pairs = new ArrayList<>();
        int size = crews.size() / 2;
        for (int i = 0; i < size * 2; i += 2) {
            pairs.add(Pair.of(crews.subList(i, i + 2)));
        }
        if (crews.size() % 2 != 0) {
            Pair lastPair = pairs.get(pairs.size() - 1);
            lastPair.addPair(crews.get(crews.size() - 1));
        }
        return pairs;
    }

    public Optional<List<Pair>> getMatchResult(MissionGroup missionGroup) {
        return matchingRepository.findByMission(missionGroup);
    }

    public void saveMatchResult(MissionGroup missionGroup, List<Pair> pairs) {
        matchingRepository.addMatchingResult(missionGroup, pairs);
    }

    public void clear() {
        matchingRepository.clear();
    }
}