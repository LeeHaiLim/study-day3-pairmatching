package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static pairmatching.domain.PairMatcher.matchPair;

public class BackMember {
    private final List<String> backMembers;

    public BackMember(List<String> backMembers) {
        this.backMembers = backMembers;
    }

    public List<List<String>> getPair() {
        List<String> shuffle = Randoms.shuffle(backMembers);
        return PairMatcher.matchPair(shuffle);
    }
}
