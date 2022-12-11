package pairmatching.view.input;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.constant.Function;
import pairmatching.constant.Mission;

public class InputView {

    private static final String REQUEST_FUNCTION = "기능을 선택하세요.";
    private static final String REQUEST_MISSION = "과정, 레벨, 미션을 선택하세요.";
    private static final String MISSION_FORM_EXAMPLE = "ex) 백엔드, 레벨1, 자동차경주";
    private static final String REQUEST_RETRY_MATCHING = "\n매칭 정보가 있습니다. 다시 매칭하시겠습니까?";
    private static final String RETRY_MATCHING_FORM_EXAMPLE = "네 | 아니요";

    public Function readFunction() {
        print(REQUEST_FUNCTION);
        return null;
    }

    public Mission readMission() {
        print(REQUEST_MISSION);
        print(MISSION_FORM_EXAMPLE);
        return null;
    }

    public boolean readRetryMatching() {
        print(REQUEST_RETRY_MATCHING);
        print(RETRY_MATCHING_FORM_EXAMPLE);
        return false;
    }

    private String read() {
        return Console.readLine();
    }

    private void print(String message) {
        System.out.println(message);
    }
}
