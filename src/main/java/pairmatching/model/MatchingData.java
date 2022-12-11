package pairmatching.model;

import java.util.List;

public class MatchingData {
    Course course;
    Level level;
    List<Pair> pairs;

    public MatchingData(Course course, Level level, List<Pair> pairs) {
        this.course = course;
        this.level = level;
        this.pairs = pairs;
    }

    public Course getCourse() {
        return course;
    }

    public Level getLevel() {
        return level;
    }

    public List<Pair> getPairs() {
        return pairs;
    }
}
