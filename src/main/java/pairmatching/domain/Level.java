package pairmatching.domain;

import java.util.Arrays;

public enum Level {
    ONE("레벨1"),
    TWO("레벨2"),
    THREE("레벨3"),
    FOUR("레벨4"),
    FIVE("레벨5");

    private final String levelName;

    Level(String levelName) {
        this.levelName = levelName;
    }

    public static Level from(String levelInput) {
        return Arrays.stream(Level.values())
                .filter(level -> level.levelName.equals(levelInput))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] "));
    }
}
