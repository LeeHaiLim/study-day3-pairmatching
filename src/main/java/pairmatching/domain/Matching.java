package pairmatching.domain;

import pairmatching.constant.Course;
import pairmatching.constant.Mission;
import java.util.List;

public class Matching {

    private final Course course;
    private final Mission mission;
    private final List<Pair> pairs;

    public Matching(Course course, Mission mission, List<Pair> pairs) {
        this.course = course;
        this.mission = mission;
        this.pairs = pairs;
    }

    public boolean isSameMatching(Matching matching) {
        return this.course == matching.getCourse()
                && this.mission == matching.getMission();
    }

    public Course getCourse() {
        return course;
    }

    public Mission getMission() {
        return mission;
    }


}
