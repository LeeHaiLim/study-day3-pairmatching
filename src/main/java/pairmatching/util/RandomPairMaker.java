package pairmatching.util;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Crew;
import pairmatching.domain.MissionGroup;
import pairmatching.domain.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class RandomPairMaker {

    public static List<Pair> getRandomPair(MissionGroup missionGroup, List<String> crews) {
        return convertToPair(shuffleOrder(crews).stream()
                .map(name -> Crew.of(missionGroup.getCourse(), name))
                .collect(Collectors.toList()));
    }

    private static List<String> shuffleOrder(List<String> crews) {
        return Randoms.shuffle(crews);
    }

    private static List<Pair> convertToPair(List<Crew> crews) {
        List<Pair> pairs = new ArrayList<>();
        int size = crews.size() / 2;
        for (int i = 0; i < size * 2; i += 2) {
            pairs.add(Pair.of(crews.subList(i, i + 2)));
        }
        if (crews.size() % 2 != 0) {
            Pair lastPair = pairs.get(pairs.size() - 1);
            lastPair.addPair(crews.get(crews.size() - 1));
        }
        return pairs;
    }
}