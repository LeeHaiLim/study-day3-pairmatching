package pairmatching.domain;

import java.util.Objects;

public class PairKey {
    private final Course course;
    private final Level level;
    private final Mission mission;

    public PairKey(String[] keys) {
        validate(keys);
        this.course = Course.findCourse(keys[0].trim());
        this.level = Level.findLevel(keys[1].trim());
        this.mission = Mission.findMission(keys[1].trim(), keys[2].trim());
    }

    private void validate(String[] keys) {
        if (keys.length != 3) {
            throw new IllegalArgumentException("항목이 3개여야 합니다.");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PairKey pairKey = (PairKey) o;
        return course.equals(pairKey.course) && level.equals(pairKey.level) && mission.equals(pairKey.mission);
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, mission);
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public Mission getMission() {
        return mission;
    }
}
