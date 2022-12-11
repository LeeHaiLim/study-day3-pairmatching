package pairmatching.domain;

import java.util.Arrays;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course from(String input) {
        return Arrays.stream(Course.values())
                .filter(course -> course.name.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("올바른 과정을 선택해주세요."));
    }
}