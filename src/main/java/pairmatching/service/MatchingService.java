package pairmatching.service;

import pairmatching.domain.MissionGroup;
import pairmatching.domain.Pair;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MatchingRepository;
import pairmatching.util.RandomPairMaker;

import java.util.List;

public class MatchingService {
    private CrewRepository crewRepository = new CrewRepository();
    private MatchingRepository matchingRepository = new MatchingRepository();

    public List<Pair> matchPairs(MissionGroup missionGroup) {
        List<String> crews = crewRepository.getCrewsByCourse(missionGroup.getCourse());
        if (crews.size() < 2) {
            throw new IllegalArgumentException("2명 이상일 때 매칭할 수 있습니다.");
        }
        if (matchingRepository.getSameLevelPairs(missionGroup)==null) {
            return RandomPairMaker.getRandomPair(missionGroup, crews);
        }
        return getValidMatchingPairs(missionGroup, crews);
    }

    private List<Pair> getValidMatchingPairs(MissionGroup missionGroup, List<String> crews) {
        for (int i = 0; i < 3; i++) {
            List<Pair> randomOrder = RandomPairMaker.getRandomPair(missionGroup, crews);
            List<Pair> repositoryPairs = matchingRepository.getSameLevelPairs(missionGroup);
            if (!hasSamePair(randomOrder, repositoryPairs)) {
                return randomOrder;
            }
        }
        throw new IllegalArgumentException("매칭할 수 없습니다.");
    }

    private boolean hasSamePair(List<Pair> randomOrder, List<Pair> pairs) {
        return randomOrder.stream()
                .anyMatch(randomPair -> pairs.stream()
                        .anyMatch(pair -> pair.isSamePair(randomPair)));
    }

    public List<Pair> getMatchResult(MissionGroup missionGroup) {
        return matchingRepository.findByMission(missionGroup);
    }

    public void saveMatchResult(MissionGroup missionGroup, List<Pair> pairs) {
        matchingRepository.addMatchingResult(missionGroup, pairs);
    }

    public void clear() {
        matchingRepository.clear();
    }
}