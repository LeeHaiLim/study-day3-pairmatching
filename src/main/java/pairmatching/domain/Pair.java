package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pair {
    private final List<Crew> pair = new ArrayList<>();

    private Pair(List<Crew> crews) {
        pair.addAll(crews);
    }

    public static Pair of(List<Crew> crews) {
        return new Pair(crews);
    }

    public void addPair(Crew crew) {
        pair.add(crew);
    }

    public boolean isSamePair(Pair comparePair) {
        long count = comparePair.pair.stream()
                .filter(crew -> pair.contains(crew))
                .count();
        return count >= 2;
    }

    public List<String> getPair() {
        return pair.stream().map(Crew::getName).collect(Collectors.toList());
    }
}