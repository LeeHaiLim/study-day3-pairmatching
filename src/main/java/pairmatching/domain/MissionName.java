package pairmatching.domain;

import java.util.Arrays;

public enum MissionName {
    RACING_CAR("자동차경주"),
    LOTTO("로또"),
    NUMBER_BASEBALL("숫자야구게임"),
    SHOPPING_BAG("장바구니"),
    PAYMENT("결제"),
    SUBWAY("지하철노선도"),
    REFACTORING("성능개선"),
    DISTRIBUTE("배포");

    private final String name;

    MissionName(String name) {
        this.name = name;
    }

    public static MissionName from(String input) {
        return Arrays.stream(MissionName.values())
                .filter(missionName -> missionName.name.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("올바른 미션을 선택해주세요"));
    }
}