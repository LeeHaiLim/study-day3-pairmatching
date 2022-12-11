package pairmatching.service;

import pairmatching.constant.Course;
import pairmatching.constant.Mission;
import pairmatching.dto.MatchingDto;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MatchingRepository;

public class MatchingService {

    private final CrewRepository crewRepository = new CrewRepository();
    private MatchingRepository matchingRepository = new MatchingRepository();

    public void match(Course course, Mission mission) {

    }

    public MatchingDto getMatchingDto(Course course, Mission mission) {
        return null;
    }

    public boolean isAlreadyMatched(Course course, Mission mission) {
        return false;
    }

    public void initialize() {

    }
}
