package pairmatching.domain;

import java.util.Objects;

public class PairKey {
    private Course course;
    private Level level;
    private Mission mission;

    public PairKey(Course course, Level level, Mission mission) {
        this.course = course;
        this.level = level;
        this.mission = mission;
    }

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
        return course == pairKey.course && level == pairKey.level && mission == pairKey.mission;
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
