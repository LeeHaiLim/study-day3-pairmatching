package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public static String readMenu() {
        InputMessage.MenuMessage();
        return Console.readLine();
    }
}
