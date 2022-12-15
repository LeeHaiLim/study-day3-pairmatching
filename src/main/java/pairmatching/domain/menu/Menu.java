package pairmatching.domain.menu;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Menu {
    MATCHING("1"), INFO("2"), RESET("3"), QUIT("Q");

    private final String code;

    Menu(String code) {
        this.code = code;
    }

    private String getCode() {
        return code;
    }

    private static final Map<String, Menu> menus = Collections.unmodifiableMap(Stream.of(values()).collect(Collectors.toMap(Menu::getCode, Function.identity())));

    public static Menu from(String number) {
        return Optional.ofNullable(menus.get(number)).orElseThrow(() -> new IllegalArgumentException("선택할 수 없는 기능입니다."));
    }
}