package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String readFeature() {
        System.out.println("기능을 선택하세요.\n"
                + "1. 페어 매칭\n"
                + "2. 페어 조회\n"
                + "3. 페어 초기화\n"
                + "Q. 종료");

        return Console.readLine().trim();
    }

    public String[] readPairKey() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");

        return Console.readLine().trim().split(", ", -1);
    }
}
