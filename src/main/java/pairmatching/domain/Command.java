package pairmatching.domain;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Command {
    YES("네"),
    NO("아니오");

    private final String code;

    Command(String code) {
        this.code = code;
    }

    private String getCode() {
        return code;
    }

    private static final Map<String, Command> menus =
            Collections.unmodifiableMap(Stream.of(values())
                    .collect(Collectors.toMap(Command::getCode, Function.identity())));

    public static Command from(String input) {
        return Optional.ofNullable(menus.get(input)).orElseThrow(
                () -> new IllegalArgumentException("네 / 아니오를 입력해주세요."));
    }
}
