package pairmatching.repository;

import pairmatching.constant.Course;
import pairmatching.constant.Mission;
import pairmatching.domain.Matching;
import java.util.ArrayList;
import java.util.List;

public class MatchingRepository {

    List<Matching> matchingList = new ArrayList<>();

    public Matching getMatching(Course course, Mission mission) {
        for (Matching matching : matchingList) {
            if (matching.isSameMatching(course, mission)){
                return matching;
            }
        }
        return null;
    }

    public boolean isAlreadyExist(Course course, Mission mission) {
        for (Matching matching : matchingList) {
            if (matching.isSameMatching(course, mission)){
                return true;
            }
        }
        return false;
    }
}
