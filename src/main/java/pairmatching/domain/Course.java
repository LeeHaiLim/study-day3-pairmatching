package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private final String name;

    public static Course findCourse(String name) {
        return Arrays.stream(Course.values())
                .filter(course -> course.name.equals(name))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("해당 과정이 없습니다."));
    }

    Course(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
