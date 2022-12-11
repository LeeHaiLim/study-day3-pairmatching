package pairmatching.domain;

public class Mission {
    private final String missionName;
    private final Level level;

    public Mission(String missionName, Level level) {
        this.missionName = missionName;
        this.level = level;
    }

    public String getName() {
        return this.missionName;
    }

    public Level getLevel() {
        return this.level;
    }
}
