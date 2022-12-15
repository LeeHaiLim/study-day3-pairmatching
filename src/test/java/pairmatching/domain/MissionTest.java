package pairmatching.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MissionTest {

    @DisplayName("같은 레벨인지 확인한다.")
    @Test
    void isSameLevel() {
        Mission racingCar = Mission.of("레벨1", "자동차경주");
        Mission lotto = Mission.of("레벨1", "로또");
        Assertions.assertThat(racingCar.isSameLevel(lotto)).isTrue();
    }

    @DisplayName("같은 레벨이 아닌지 확인한다.")
    @Test
    void isNotSameLevel() {
        Mission racingCar = Mission.of("레벨1", "자동차경주");
        Mission subway = Mission.of("레벨2", "지하철노선도");
        Assertions.assertThat(racingCar.isSameLevel(subway)).isFalse();
    }

    @DisplayName("해당 레벨의 미션이 아니면 예외처리한다.")
    @Test
    void createInvalidMission() {
        Assertions.assertThatThrownBy(() -> Mission.of("레벨2", "자동차경주"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("올바른 레벨과 미션을 선택해주세요.");
    }
}