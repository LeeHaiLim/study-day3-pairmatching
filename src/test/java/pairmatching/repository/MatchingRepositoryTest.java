package pairmatching.repository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Crew;
import pairmatching.domain.MissionGroup;
import pairmatching.domain.Pair;
import pairmatching.domain.menu.Course;

import java.util.List;

class MatchingRepositoryTest {

    private static MatchingRepository matchingRepository = new MatchingRepository();

    @BeforeAll
    static void setUp() {
        MissionGroup racingCar = MissionGroup.of(List.of("백엔드", "레벨1", "자동차경주"));
        MissionGroup lotto = MissionGroup.of(List.of("백엔드", "레벨1", "로또"));
        MissionGroup subway = MissionGroup.of(List.of("백엔드", "레벨2", "지하철노선도"));

        Crew apple = Crew.of(Course.BACKEND, "사과");
        Crew banana = Crew.of(Course.BACKEND, "바나나");
        Crew orange = Crew.of(Course.BACKEND, "오렌지");
        Crew grape = Crew.of(Course.BACKEND, "포도");

        List<Pair> racingCarPairs = List.of(Pair.of(List.of(apple, banana)), Pair.of(List.of(orange, grape)));
        List<Pair> lottoPairs = List.of(Pair.of(List.of(apple, orange)), Pair.of(List.of(banana, grape)));
        List<Pair> subwayPairs = List.of(Pair.of(List.of(apple, orange)), Pair.of(List.of(banana, grape)));
        matchingRepository.addMatchingResult(racingCar, racingCarPairs);
        matchingRepository.addMatchingResult(lotto, lottoPairs);
        matchingRepository.addMatchingResult(subway, subwayPairs);
    }

    @Test
    void findByMission() {
        MissionGroup racingCar = MissionGroup.of(List.of("백엔드", "레벨1", "자동차경주"));
        Assertions.assertThat(matchingRepository.findByMission(racingCar)).isNotNull();
    }

    @Test
    void getSameLevelPairs() {
        MissionGroup racingCar = MissionGroup.of(List.of("백엔드", "레벨1", "자동차경주"));
        List<Pair> pairs = matchingRepository.getSameLevelPairs(racingCar);
        Assertions.assertThat(pairs.size()).isEqualTo(4);

    }

    @Test
    void getSameLevelPairs2() {
        MissionGroup payment = MissionGroup.of(List.of("백엔드", "레벨2", "결제"));
        List<Pair> pairs = matchingRepository.getSameLevelPairs(payment);
        Assertions.assertThat(pairs.size()).isEqualTo(2);

    }

    @AfterAll
    static void end() {
        matchingRepository.clear();
    }
}