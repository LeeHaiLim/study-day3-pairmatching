package pairmatching.repository;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Course;
import pairmatching.domain.Level;
import pairmatching.domain.Pair;
import pairmatching.domain.PairKey;

public class PairRepository {
    private static final HashMap<PairKey, List<Pair>> pairs = new HashMap<>();

    public static void addPairs(PairKey pairKey, List<Pair> pairList) {
        pairs.put(pairKey, pairList);
    }

    public static List<Pair> getPairs(PairKey pairKey) {
        if (pairs.get(pairKey) == null) {
            throw new IllegalArgumentException("매칭 이력이 없습니다.");
        }
        return pairs.get(pairKey);
    }

    public static List<List<String>> getPairsToString(PairKey pairKey) {
        return getPairs(pairKey).stream().map(Pair::getCrewNames).collect(Collectors.toList());
    }

    public static void removePairs(PairKey pairKey) {
        pairs.remove(pairKey);
    }

    public static void clear() {
        pairs.clear();
    }

    public static boolean containsKey(PairKey pairKey) {
        return pairs.containsKey(pairKey);
    }

    public static List<Pair> getPairsByCourseAndLevel(Course course, Level level) {
        return pairs.keySet().stream()
                .filter(pairKey -> pairKey.getCourse().equals(course) && pairKey.getLevel().equals(level))
                .map(pairs::get)
                .flatMap(List::stream)
                .collect(Collectors.toList());
    }
}
