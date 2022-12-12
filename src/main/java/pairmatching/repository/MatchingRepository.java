package pairmatching.repository;

import pairmatching.domain.MissionGroup;
import pairmatching.domain.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class MatchingRepository {
    private static Map<MissionGroup, List<Pair>> matchingResults = new HashMap<>();

    public void addMatchingResult(MissionGroup missionGroup, List<Pair> pairs) {
        matchingResults.put(missionGroup, pairs);
    }

    public List<Pair> findByMission(MissionGroup missionGroup) {
        return matchingResults.get(missionGroup);
    }

    public List<Pair> getSameLevelPairs(MissionGroup missionGroup) {
        return matchingResults.keySet().stream()
                .filter(key -> key.isSameCourseAndLevel(missionGroup))
                .map(matchingResults::get)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }

    public void clear() {
        matchingResults.clear();
    }
}