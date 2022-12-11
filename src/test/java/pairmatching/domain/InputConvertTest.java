package pairmatching.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pairmatching.domain.Level.ONE;
import static pairmatching.domain.MainFunction.MATCHING;
import static pairmatching.domain.Part.FRONT_END;

class InputConvertTest {

    @DisplayName("올바르지 않은 메인 기능을 입력하면 예외를 던진다.")
    @Test
    void invalidMainInputTest() {
        String invalidInput = "13";

        Assertions.assertThatThrownBy(() -> MainFunction.from(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("메인 기능 변환 기능 테스트")
    @Test
    void convertMainInputTest() {
        String matchingInput = "1";

        Assertions.assertThat(MainFunction.from(matchingInput)).isEqualTo(MATCHING);
    }

    @DisplayName("올바르지 않은 레벨을 입력하면 예외를 던진다.")
    @Test
    void invalidLevelInputTest() {
        String invalidInput = "0";

        Assertions.assertThatThrownBy(() -> Level.from(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("레벨 변환 테스트")
    @Test
    void convertLevelInputTest() {
        String matchingInput = "레벨1";

        Assertions.assertThat(Level.from(matchingInput)).isEqualTo(ONE);
    }

    @DisplayName("올바르지 않은 파트를 입력하면 예외를 던진다.")
    @Test
    void invalidPartInputTest() {
        String invalidInput = "디자이너";

        Assertions.assertThatThrownBy(() -> Part.from(invalidInput))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("파트 변환 테스트")
    @Test
    void convertPartInputTest() {
        String matchingInput = "프론트엔드";
        Assertions.assertThat(Part.from(matchingInput)).isEqualTo(FRONT_END);
    }

}
