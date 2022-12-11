package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static final String MISSION_INPUT_REGEX = "[ㄱ-ㅎ|ㅏ-ㅣ|가-힣a-zA-Z0-9]+";
    private static final String MISSION_INPUT_DELIMITER = ",";
    public static String readMenu() {
        InputMessage.MenuMessage();
        return Console.readLine();
    }

    public static List<String> readMission() {
        InputMessage.MissionInfoMessage();
        String input = Console.readLine();
        return Arrays.stream(input.split(MISSION_INPUT_DELIMITER))
                .collect(Collectors.toList());
    }

    private static void validateMissionShape(String input) {
        boolean result = Arrays.stream(input.split(MISSION_INPUT_DELIMITER))
                .allMatch(value -> value.matches(MISSION_INPUT_REGEX));
        if (!result) {
            throw new IllegalArgumentException("과정, 레벨, 미션은 각각 쉼표로 구분하여 입력해야 합니다.");
        }
    }
}