package pairmatching.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pair {
    List<Crew> pairs = new ArrayList<>();

    public Pair(Crew... crew) {
        pairs.addAll(Arrays.asList(crew));
    }

    public List<Crew> getPairs() {
        return pairs;
    }


}
