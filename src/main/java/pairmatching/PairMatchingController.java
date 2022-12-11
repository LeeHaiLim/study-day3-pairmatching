package pairmatching;

import pairmatching.model.Course;
import pairmatching.model.Level;
import pairmatching.model.Pair;
import pairmatching.view.View;

import java.util.List;

public class PairMatchingController {
    private View view;
    private PairMatcher pairMatcher;

    public void run() {
        String cmd;
        do {
            cmd = view.selectFeature();
            if(cmd.equals(Const.MATCH_PAIR)) {
                matchPair();
                continue;
            }
            if(cmd.equals(Const.INQUIRY_PAIR)) {
                inquiryPair();
                continue;
            }
            if(cmd.equals(Const.INIT_PAIR)) {
                initPair();
                continue;
            }
            throw new IllegalArgumentException("[ERROR] 잘못된 기능이 입력되었습니다.");
        } while (!cmd.equals(Const.QUIT));
    }

    private void matchPair() {
        List<Pair> pairs = null;
        String[] splitedInput = view.selectMenu().split(", ");
        pairMatcher = new PairMatcher(Course.getCourse(splitedInput[0]), Level.getLevel(splitedInput[1]));
        pairMatcher.readCrews();
        if(pairMatcher.isExist()) {
            pairs = askRematch();
        } else {
            pairs = pairMatcher.match();
        }
        view.printPairs(pairs);
    }

    private List<Pair> askRematch() {
        String input = view.askRematch();
        if(input.equals(Const.YES)) {
            return pairMatcher.match();
        }
        return null;
    }

    private void inquiryPair() {
        view.printPairs(pairMatcher.getPairs());
    }

    private void initPair() {
        pairMatcher.initPair();
    }
}
