package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;

public class PairKeyTest {

    @Test
    public void validationTest_size() {
        assertThatThrownBy(() -> new PairKey(new String[]{"백엔드", "레벨1", "로또", "오징어게임"}))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new PairKey(new String[]{"백엔드", "레벨1"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validationTest_course() {
        assertThatThrownBy(() -> new PairKey(new String[]{"안드로이드", "레벨1", "로또"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validationTest_level() {
        assertThatThrownBy(() -> new PairKey(new String[]{"백엔드", "레벨7", "로또"}))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void validationTest_mission() {
        assertThatThrownBy(() -> new PairKey(new String[]{"백엔드", "레벨1", "오징어게임"}))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
