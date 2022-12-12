package pairmatching.repository;

import pairmatching.domain.MissionGroup;
import pairmatching.domain.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class MatchingRepository {
    private static Map<MissionGroup, List<Pair>> matchingResults = new HashMap<>();

    public void addMatchingResult(MissionGroup missionGroup, List<Pair> pairs) {
        matchingResults.put(missionGroup, pairs);
    }

    public Optional<List<Pair>> findByMission(MissionGroup missionGroup) {
        return Optional.ofNullable(matchingResults.get(missionGroup));
    }

    public Optional<List<Pair>> getSameLevelPairs(MissionGroup missionGroup) {
        return Optional.ofNullable(matchingResults.keySet().stream()
                .filter(key -> key.isSameCourseAndLevel(missionGroup))
                .map(matchingResults::get)
                .flatMap(List::stream)
                .collect(Collectors.toList()));
    }

    public void clear() {
        matchingResults.clear();
    }
}