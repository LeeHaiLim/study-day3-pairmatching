package pairmatching;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.repository.CrewRepository;

public class InitiatorTest {
    @Test
    public void initTest() {
        Initiator.init();
        List<Crew> backendCrew = CrewRepository.getCrewsByCourse(Course.BACKEND);
        List<Crew> frontendCrew = CrewRepository.getCrewsByCourse(Course.FRONTEND);

        assertThat(backendCrew).isNotNull();
        assertThat(frontendCrew).isNotNull();
    }
}
