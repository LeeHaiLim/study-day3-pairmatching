package pairmatching.domain;

import java.util.Arrays;

public enum Command {
    YES("네"),
    NO("아니오");

    private final String code;

    Command(String code) {
        this.code = code;
    }

    public static Command from(String input) {
        return Arrays.stream(Command.values())
                .filter(command -> command.code.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("네 / 아니오를 입력해주세요."));
    }
}
