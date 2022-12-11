package pairmatching.dto;

import pairmatching.constant.Course;
import pairmatching.constant.Mission;

public class MissionDto {

    private final Course course;
    private final Mission mission;

    MissionDto(Course course, Mission mission) {
        this.course = course;
        this.mission = mission;
    }

    public Course getCourse() {
        return course;
    }

    public Mission getMission() {
        return mission;
    }
}
