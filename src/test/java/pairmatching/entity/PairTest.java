package pairmatching.entity;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import pairmatching.constant.Course;
import pairmatching.domain.Pair;
import pairmatching.domain.Crew;
import java.util.List;
import java.util.stream.Stream;

public class PairTest {

    private static final Crew CREW1 = new Crew("11", Course.BACKEND);
    private static final Crew CREW2 = new Crew("22", Course.BACKEND);
    private static final Crew CREW3 = new Crew("33", Course.BACKEND);

    @ParameterizedTest(name = "Case {index}")
    @ArgumentsSource(OverlappedTestData.class)
    void isPairOverlappedTest(Pair pair, Pair comparedPair, boolean expected) {
        boolean result = pair.isPairOverlapped(comparedPair);

        assertThat(result).isEqualTo(expected);
    }

    static class OverlappedTestData implements ArgumentsProvider {

        @Override
        public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
            return Stream.of(
                    Arguments.of(new Pair(List.of(CREW1, CREW2)),
                            new Pair(List.of(CREW3, CREW2)), false),
                    Arguments.of(new Pair(List.of(CREW1, CREW2)),
                            new Pair(List.of(CREW1, CREW2)), true),
                    Arguments.of(new Pair(List.of(CREW1, CREW2, CREW3)),
                            new Pair(List.of(CREW1, CREW2)), true)
            );
        }
    }
}
