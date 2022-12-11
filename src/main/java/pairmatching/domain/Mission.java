package pairmatching.domain;

public class Mission {
    private final String missionName;
    private final Level level;
    private final Part part;

    public Mission(String missionName, Level level, Part part) {
        this.missionName = missionName;
        this.level = level;
        this.part = part;
    }

    public String getName() {
        return this.missionName;
    }

    public Level getLevel() {
        return this.level;
    }

    public Part getPart() {
        return this.part;
    }
}
