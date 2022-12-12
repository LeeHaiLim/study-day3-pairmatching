package pairmatching.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pairmatching.domain.menu.Course;

import java.util.List;

class PairTest {

    @Test
    void isSamePairTest() {
        Crew apple = Crew.of(Course.BACKEND, "사과");
        Crew banana = Crew.of(Course.BACKEND, "바나나");
        Crew orange = Crew.of(Course.BACKEND, "오렌지");

        Pair pair1 = Pair.of(List.of(apple, banana, orange));
        Pair pair2 = Pair.of(List.of(banana, orange));
        Assertions.assertThat(pair1.isSamePair(pair2)).isTrue();
    }
}