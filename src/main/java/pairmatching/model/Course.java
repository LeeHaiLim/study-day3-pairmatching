package pairmatching.model;

import java.util.Optional;

public enum Course {
    BACKEND("백엔드"),
    FRONTEND("프론트엔드");

    private String name;

    Course(String name) {
        this.name = name;
    }

    public static Course getCourse(String name) {
        for(Course course : values()) {
            if(course.name.equals(name)) {
                return course;
            }
        }
        return null;
    }
}
