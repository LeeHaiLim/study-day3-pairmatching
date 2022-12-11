package pairmatching.constant;

public enum Mission {
    RACING_CAR(1),
    LOTTO(1),
    NUMBER_BASEBALL(1),
    SHOPPING_BASKET(2),
    PAYMENT(2),
    SUBWAY_MAP(2),
    PERFORMANCE_IMPROVEMENT(4),
    DEPLOY(4),
    ;

    private final int level;

    Mission(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }

    public boolean isEqualLevel(Mission mission) {
        return mission.getLevel() == this.level;
    }
}
