package pairmatching.repository;

import pairmatching.domain.Crew;
import pairmatching.domain.Mission;
import pairmatching.domain.Pair;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class MatchingRepository {
    private static Map<Mission, List<Pair>> matchingResults = new HashMap<>();

    public void addMatchingResult(Mission mission, List<Pair> pairs) {
        matchingResults.put(mission, pairs);
    }

    public List<Pair> findByMission(Mission mission) {
        return Optional.ofNullable(matchingResults.get(mission))
                .orElseThrow(() -> new IllegalArgumentException("매칭 이력이 없습니다."));
    }
    public boolean hasPair(Mission mission) {
        return matchingResults.containsKey(mission);
    }

    public boolean hasSameLevelSamePair(Mission mission, List<Crew> crews) {
        boolean result = matchingResults.keySet().stream()
                .filter(key -> key.isSameLevel(mission))
                .noneMatch(key -> hasSamePair(key, crews));
        if (result) {
            return false;
        }
        return true;
    }

    private boolean hasSamePair(Mission key, List<Crew> crews) {
        List<Pair> pairs = matchingResults.get(key);
        if (crews.size() % 2 == 0) {
            return hasSamePairEven(pairs, crews);
        }
        return hasSamePairOdd(pairs, crews);

    }

    private boolean hasSamePairEven(List<Pair> pairs, List<Crew> crews) {
        for (int i = 0; i < crews.size(); i += 2) {
            Pair pair = pairs.get(i / 2);
            if (pair.isSamePair(crews.subList(i, i + 2))) {
                return true;
            };
        }
        return false;
    }

    private boolean hasSamePairOdd(List<Pair> pairs, List<Crew> crews) {
        if (hasSamePairEven(pairs.subList(0, pairs.size()-1), crews.subList(0, crews.size()-3))){
            return true;
        }
        Pair pair = pairs.get(pairs.size()-1);
        if (pair.isSamePair(crews.subList(crews.size()-3, crews.size()))) {
            return true;
        }
        return false;
    }
}
