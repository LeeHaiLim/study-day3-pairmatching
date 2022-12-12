package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String MISSION_INPUT_DELIMITER = ",";

    public static String readMenu() {
        InputMessage.MenuMessage();
        return Console.readLine();
    }

    public static List<String> readMission() {
        System.out.println("과정, 레벨, 미션을 선택하세요.\n" +
                "ex) 백엔드, 레벨1, 자동차경주");
        String input = Console.readLine();
        validateMissionShape(input);
        return Arrays.stream(input.split(MISSION_INPUT_DELIMITER))
                .map(s -> s.replaceAll(" ", ""))
                .collect(Collectors.toList());
    }

    public static String readCommend() {
        InputMessage.retryMessage();
        return Console.readLine();
    }

    private static void validateMissionShape(String input) {
        String[] inputSplit = input.split(MISSION_INPUT_DELIMITER);
        if (inputSplit.length != 3) {
            throw new IllegalArgumentException("과정, 레벨, 미션은 각각 쉼표로 구분하여 입력해야 합니다.");
        }
    }
}