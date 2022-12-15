package pairmatching.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Crew;
import pairmatching.domain.MissionGroup;
import pairmatching.domain.Pair;
import pairmatching.domain.menu.Course;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.MatchingRepository;

import java.util.List;

class MatchingServiceTest {
    private MatchingService matchingService = new MatchingService();
    private static MatchingRepository matchingRepository = new MatchingRepository();
    private static CrewSaveService crewSaveService = new CrewSaveService();
    private static CrewRepository crewRepository = new CrewRepository();

    @BeforeAll
    static void setUp() {
        matchingRepository.clear();
        List<Crew> crews = List.of(
                Crew.of(Course.BACKEND, "A"),
                Crew.of(Course.BACKEND, "B"),
                Crew.of(Course.BACKEND, "C"),
                Crew.of(Course.BACKEND, "D"),
                Crew.of(Course.BACKEND, "E"),
                Crew.of(Course.BACKEND, "F"),
                Crew.of(Course.BACKEND, "G"));
        crews.stream().forEach(crewRepository::addCrew);
    }

    @Test
    void matchPairs() {
        MissionGroup racingCar = MissionGroup.of(List.of("백엔드", "레벨1", "자동차경주"));
        MissionGroup lotto = MissionGroup.of(List.of("백엔드", "레벨1", "로또"));
        Crew A = Crew.of(Course.BACKEND, "A");
        Crew B = Crew.of(Course.BACKEND, "B");
        Crew C = Crew.of(Course.BACKEND, "C");
        Crew D = Crew.of(Course.BACKEND, "D");
        Crew E = Crew.of(Course.BACKEND, "E");
        Crew F = Crew.of(Course.BACKEND, "F");
        Crew G = Crew.of(Course.BACKEND, "G");
        List<Pair> racingCarPairs = List.of(Pair.of(List.of(A, B)), Pair.of(List.of(C, D)), Pair.of(List.of(E, F, G)));
        matchingRepository.addMatchingResult(racingCar, racingCarPairs);

        List<Pair> pairs = matchingService.matchPairs(lotto);
        Assertions.assertThat(pairs).doesNotContain(Pair.of(List.of(A, B)),
                Pair.of(List.of(C, D)),
                Pair.of(List.of(E, F)),
                Pair.of(List.of(E, G)),
                Pair.of(List.of(F, G))
        );
    }

    @AfterAll
    static void end() {
        matchingRepository.clear();
    }
}