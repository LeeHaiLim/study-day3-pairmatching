package pairmatching.helper;

import pairmatching.domain.Crew;
import pairmatching.domain.Pair;
import java.util.ArrayList;
import java.util.List;

public class CrewMatcher {

    public static List<Pair> matchRandom(List<Crew> crews) {
        List<Crew> shuffledCrews = CrewShuffler.shuffle(crews);

        if (crews.size() % 2 == 0) {
            return matchWhenSizeEven(shuffledCrews);
        }
        return matchWhenSizeOdd(shuffledCrews);
    }

    private static List<Pair> matchWhenSizeEven(List<Crew> crews) {
        List<Pair> pairs = new ArrayList<>();
        for (int index = 0; index < crews.size(); index += 2) {
            pairs.add(new Pair(List.of(crews.get(index), crews.get(index + 1))));
        }
        return pairs;
    }

    private static List<Pair> matchWhenSizeOdd(List<Crew> crews) {
        List<Pair> pairs = new ArrayList<>();
        for (int index = 0; index < crews.size()-3; index += 2) {
            pairs.add(new Pair(List.of(crews.get(index), crews.get(index + 1))));
        }

        int size = crews.size();
        pairs.add(new Pair(List.of(crews.get(size-3), crews.get(size-2), crews.get(size-1))));
        return pairs;
    }
}
