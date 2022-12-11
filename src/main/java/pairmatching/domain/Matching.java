package pairmatching.domain;

import pairmatching.constant.Course;
import pairmatching.constant.Mission;
import pairmatching.dto.MatchingDto;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

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

    public boolean isSameMatching(Course course, Mission mission) {
        return this.course == course
                && this.mission == mission;
    }

    public boolean isExistOverlappedPair(Matching matching) {
        for (Pair pair : this.pairs) {
            if (pair.isPairOverlapped(matching.getPairs())) {
               return true;
            }
        }
        return false;
    }

    public MatchingDto getMatchingDto() {
        List<List<String>> matchInfo = this.pairs.stream()
                .map(Pair::getPairDto)
                .collect(Collectors.toList());
        return new MatchingDto(matchInfo);
    }

    public Course getCourse() {
        return course;
    }

    public Mission getMission() {
        return mission;
    }

    public List<Pair> getPairs() {
        return Collections.unmodifiableList(pairs);
    }
}
