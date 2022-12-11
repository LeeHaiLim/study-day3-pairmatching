package pairmatching.domain;

import pairmatching.constant.Course;

public class Crew {

    private final String name;
    private final Course course;

    Crew(String name, Course course) {
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

}
