package pairmatching.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomPairMaker {

    public static List<String> getRandomOrder(List<String> crews) {
        return Randoms.shuffle(crews);
    }
}