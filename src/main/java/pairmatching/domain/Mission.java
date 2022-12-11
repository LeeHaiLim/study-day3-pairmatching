package pairmatching.domain;

import static pairmatching.domain.Level.LEVEL1;
import static pairmatching.domain.Level.LEVEL2;
import static pairmatching.domain.Level.LEVEL4;


import java.util.Arrays;

public enum Mission {
    RACING_CAR(LEVEL1, "자동차경주"),
    LOTTO(LEVEL1, "로또"),
    BASEBALL(LEVEL1, "숫자야구게임"),
    CART(LEVEL2, "장바구니"),
    PAYMENT(LEVEL2, "결제"),
    SUBWAY_PATH(LEVEL2, "지하철노선도"),
    PERFORMANCE(LEVEL4, "성능개선"),
    DEPLOYMENT(LEVEL4, "배포");

    private final Level level;
    private final String name;

    Mission(Level level, String name) {
        this.level = level;
        this.name = name;
    }

    public static Mission findMission(String levelName, String missionName) {
        return Arrays.stream(Mission.values())
                .filter(mission -> mission.level.getName().equals(levelName) && mission.name.equals(missionName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 레벨에 해당 미션이 없습니다."));
    }
}
