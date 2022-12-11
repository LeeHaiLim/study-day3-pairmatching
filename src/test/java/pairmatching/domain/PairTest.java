package pairmatching.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PairTest {
    @Test
    void isSamePairTest() {
        Crew crew1 = Crew.of(Course.BACKEND, "가");
        Crew crew2 = Crew.of(Course.BACKEND, "나");
        Crew crew3 = Crew.of(Course.BACKEND, "다");
        List<Crew> pair = new ArrayList<>();
        pair.add(crew1);
        pair.add(crew2);
        pair.add(crew3);
        Pair pair1 = Pair.of(pair);

        List<Crew> pair2 = new ArrayList<>();
        pair2.add(crew2);
        pair2.add(crew3);

        Assertions.assertThat(pair1.isSamePair(pair2)).isTrue();
    }
}