package pairmatching.util;

import java.util.Arrays;

public enum Command {
    YES("네"),
    NO("아니오");

    private final String code;

    Command(String code) {
        this.code = code;
    }

    public static Command findCommand(String code) {
        return Arrays.stream(Command.values())
                .filter(command -> command.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("네, 아니오 중 하나를 입력해야 합니다."));
    }

    public String code() {
        return code;
    }
}
