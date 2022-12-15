package pairmatching.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MissionGroupTest {

    @DisplayName("같은 코스의 같은 레벨인지 확인한다.")
    @Test
    void isSameCourseAndLevel() {
        MissionGroup racingCar = MissionGroup.of(List.of("프론트엔드", "레벨1", "자동차경주"));
        MissionGroup lotto = MissionGroup.of(List.of("프론트엔드", "레벨1", "로또"));

        Assertions.assertThat(racingCar.isSameCourseAndLevel(lotto)).isTrue();
    }

    @DisplayName("같은 코스의 같은 레벨이 아닌지 확인한다.")
    @Test
    void isNotSameCourseAndLevel() {
        MissionGroup racingCar = MissionGroup.of(List.of("프론트엔드", "레벨1", "자동차경주"));
        MissionGroup subway = MissionGroup.of(List.of("프론트엔드", "레벨2", "지하철노선도"));

        Assertions.assertThat(racingCar.isSameCourseAndLevel(subway)).isFalse();
    }
}