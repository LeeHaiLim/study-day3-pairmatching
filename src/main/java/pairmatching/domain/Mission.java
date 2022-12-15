package pairmatching.domain;

import pairmatching.domain.menu.Level;

import java.util.Arrays;

public enum Mission {
    RACING_CAR(Level.LEVEL1, "자동차경주"),
    LOTTO(Level.LEVEL1, "로또"),
    NUMBER_BASEBALL(Level.LEVEL1, "숫자야구게임"),
    SHOPPING_BAG(Level.LEVEL2, "장바구니"),
    PAYMENT(Level.LEVEL2, "결제"),
    SUBWAY(Level.LEVEL2, "지하철노선도"),
    REFACTORING(Level.LEVEL4, "성능개선"),
    DISTRIBUTE(Level.LEVEL4, "배포");

    private final Level level;
    private final String name;

    Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }

    public static Mission of(String inputLevel, String inputName) {
        return Arrays.stream(Mission.values())
                .filter(mission -> mission.level.equals(Level.from(inputLevel))
                        && mission.name.equals(inputName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("올바른 레벨과 미션을 선택해주세요."));
    }

    public boolean isSameLevel(Mission mission) {
        return this.level == mission.level;
    }
}