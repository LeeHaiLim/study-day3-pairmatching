package pairmatching.util;

import java.util.Arrays;

public enum FeatureMenu {
    PAIR_MATCHING("1"),
    PAIR_QUERY("2"),
    PAIR_INIT("3"),
    QUIT("Q");

    private final String code;

    FeatureMenu(String code) {
        this.code = code;
    }

    public static FeatureMenu findMenu(String code) {
        return Arrays.stream(FeatureMenu.values())
                .filter(menu -> menu.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("1, 2, 3, Q 중 하나를 입력해야 합니다."));
    }
}
