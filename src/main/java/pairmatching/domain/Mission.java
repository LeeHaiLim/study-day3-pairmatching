package pairmatching.domain;

import java.util.Objects;

public class Mission {
    private final Course course;
    private final Level level;
    private final MissionName name;

    private Mission(Course course, Level level, MissionName name) {
        this.course = course;
        this.level = level;
        this.name = name;
    }

    public static Mission of(String course, String leven, String name) {
        return new Mission(Course.from(course), Level.from(leven), MissionName.from(name));
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, level, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Mission)) {
            return false;
        }
        Mission mission = (Mission) obj;
        if (this.course.equals((mission.course))
                && this.level.equals((mission.level))
                && this.name.equals((mission.name))) {
            return true;
        }
        return false;
    }
}