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

    public Course getCourse() {
        return course;
    }

    @Override
    public boolean equals(Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Crew)) {
            return false;
        }
        if (((Crew) object).getName().equals(name)
                && ((Crew) object).getCourse().equals(course)) {
            return true;
        }
        return false;
    }
}
