package pairmatching.domain;

import pairmatching.domain.menu.Course;

import java.util.Objects;

public class Crew {
    private Course course;
    private String name;

    private Crew(Course course, String name) {
        this.course = course;
        this.name = name;
    }

    public static Crew of(Course course, String name) {
        return new Crew(course, name);
    }

    public boolean isBackendCrew() {
        return course == Course.BACKEND;
    }

    public boolean isFrontendCrew() {
        return course == Course.FRONTEND;
    }

    public String getName() {
        return name;
    }

    @Override
    public int hashCode() {
        return Objects.hash(course, name);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Crew)) {
            return false;
        }
        Crew crew = (Crew) obj;
        if (this.course.equals(crew.course) && this.name.equals(crew.name)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return course.name()+" " +name;
    }
}