package pairmatching.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Pair {
    private final Set<Crew> pair = new HashSet<>();

    private Pair(List<Crew> crews) {
        crews.stream().forEach(pair::add);
    }

    public static Pair of(List<Crew> crews) {
        return new Pair(crews);
    }

    public boolean isSamePair(List<Crew> crews) {
        long count = crews.stream()
                .filter(crew -> pair.contains(crew))
                .count();
        if (count < 2) {
            return false;
        }
        return true;
    }
}
