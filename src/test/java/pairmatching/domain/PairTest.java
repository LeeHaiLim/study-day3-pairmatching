package pairmatching.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

public class PairTest {

    @Test
    public void equalsTest_exact() {
        Pair pair1 = new Pair(Arrays.stream(new String[]{"A","B"}).collect(Collectors.toList()));
        Pair pair2 = new Pair(Arrays.stream(new String[]{"A","B"}).collect(Collectors.toList()));

        assertThat(pair1).isEqualTo(pair2);
    }

    @Test
    public void equalsTest_contain() {
        Pair pair1 = new Pair(Arrays.stream(new String[]{"A","B","C"}).collect(Collectors.toList()));
        Pair pair2 = new Pair(Arrays.stream(new String[]{"A","B"}).collect(Collectors.toList()));

        assertThat(pair1).isEqualTo(pair2);
    }
}
