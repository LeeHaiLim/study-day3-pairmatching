package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Pair {
    private final List<Crew> pair = new ArrayList<>();

    private Pair(List<Crew> crews) {
        crews.stream().forEach(pair::add);
    }

    public static Pair of(List<Crew> crews) {
        return new Pair(crews);
    }

    public boolean isContain(Crew crew) {
        return pair.contains(crew);
    }

    public boolean isSamePair(List<Crew> crews) {
        long count = crews.stream()
                .filter(this::isContain)
                .count();
        if (count >= 2) {
            return true;
        }
        return false;
    }

    public List<String> getPair() {
        return pair.stream().map(Crew::getName).collect(Collectors.toList());
    }
}
