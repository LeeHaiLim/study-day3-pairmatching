package pairmatching.domain;

import java.util.Arrays;

public enum Menu {
    MATCHING("1"),
    INFO("2"),
    RESET("3"),
    QUIT("Q");

    private final String code;

    Menu(String code) {
        this.code = code;
    }

    public static Menu from(String input) {
        return Arrays.stream(Menu.values())
                .filter(menu -> menu.code.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("올바른 기능을 선택해주세요"));
    }
}
