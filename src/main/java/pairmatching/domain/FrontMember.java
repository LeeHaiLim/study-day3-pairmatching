package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class FrontMember {
    private final List<String> frontMembers;

    public FrontMember(List<String> frontMembers) {
        this.frontMembers = frontMembers;
    }

    public List<List<String>> getPair() {
        List<String> shuffle = Randoms.shuffle(frontMembers);
        return PairMatcher.matchPair(shuffle);
    }
}
