package pairmatching.domain;

import pairmatching.domain.menu.Course;

import java.util.List;
import java.util.Objects;

public class MissionGroup {
    private final Course course;
    private final Mission mission;

    private MissionGroup(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    public static MissionGroup of(List<String> input) {
        return new MissionGroup(Course.from(input.get(0)), Mission.of(input.get(1), input.get(2)));
    }

    public boolean isSameCourseAndLevel(MissionGroup missionGroup) {
        return this.course.equals(missionGroup.course)
                && this.mission.isSameLevel(missionGroup.mission);
    }

    public Course getCourse() {
        return course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, mission);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof MissionGroup)) {
            return false;
        }
        MissionGroup missionGroup = (MissionGroup) obj;
        return this.course.equals((missionGroup.course))
                && this.mission.equals((missionGroup.mission));
    }
}