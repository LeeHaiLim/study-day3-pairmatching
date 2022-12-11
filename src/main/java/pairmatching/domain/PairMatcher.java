package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PairMatcher {
    public static List<List<String>> matchPair(List<String> shuffle) {
        List<List<String>> pair = new ArrayList<>();
        int pairNum = shuffle.size() / 2;

        for (int i = 0; i < pairNum * 2; i += 2) {
            pair.add(Arrays.asList(shuffle.get(i), shuffle.get(i + 1)));
        }
        if (shuffle.size() % 2 != 0) {
            pair.get(pair.size() - 1).add(shuffle.get(shuffle.size() - 1));
        }
        return pair;
    }
}
