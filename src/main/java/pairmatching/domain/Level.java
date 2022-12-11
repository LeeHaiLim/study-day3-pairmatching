package pairmatching.domain;

import java.util.Arrays;

public enum Level {
    LEVEL1("레벨1"),
    LEVEL2("레벨2"),
    LEVEL3("레벨3"),
    LEVEL4("레벨4"),
    LEVEL5("레벨5");

    private final String name;

    public static Level findLevel(String name) {
        return Arrays.stream(Level.values())
                .filter(level -> level.name.equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 레벨이 없습니다."));
    }

    Level(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
