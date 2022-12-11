package pairmatching.util;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RandomShuffle {

    public List<String> getRandomOrder(List<String> crews) {
        return Randoms.shuffle(crews);
    }
}