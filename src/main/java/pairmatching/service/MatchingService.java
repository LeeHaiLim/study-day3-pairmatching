package pairmatching.service;

import pairmatching.domain.Crew;
import pairmatching.domain.Mission;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MatchingRepository;
import pairmatching.util.RandomShuffle;

import java.util.List;

public class MatchingService {
    private CrewRepository crewRepository = new CrewRepository();
    private RandomShuffle randomShuffle = new RandomShuffle();
    private MatchingRepository matchingRepository = new MatchingRepository();

    public boolean hasPair(Mission mission) {
        return matchingRepository.hasPair(mission);
    }
}
