package pairmatching.repository;

import pairmatching.domain.Crew;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MatchingRepository {
    private static Map<Mission, List<Pair>> matchingResults = new HashMap<>();

    public void addMatchingResult(Mission mission, List<Pair> pairs) {
        matchingResults.put(mission, pairs);
    }

    public boolean hasPair(Mission mission) {
        return matchingResults.containsKey(mission);
    }
}
