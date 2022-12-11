package pairmatching.helper;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import pairmatching.domain.Crew;
import java.util.List;

public class CrewReaderTest {

    @Test
    void readBackendCrewTest() {
        List<Crew> result = CrewReader.readBackendCrews();

        // backend-crew.md 파일 정보에 따라 값이 달라질 수 있다.
        assertThat(result.size()).isEqualTo(20);
    }
}
