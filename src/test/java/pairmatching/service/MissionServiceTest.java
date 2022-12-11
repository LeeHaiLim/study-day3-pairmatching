package pairmatching.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Part;
import pairmatching.repository.missionrepository.MemoryMissionRepository;
import pairmatching.repository.missionrepository.MissionRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MissionServiceTest {

    MissionService missionService;
    MissionRepository missionRepository;

    @BeforeEach
    void setUp() {
        missionRepository = new MemoryMissionRepository();
        missionService = new MissionService(missionRepository);
        missionService.init();
    }

    @Test
    void createMissionPairMatchingTest() {
        missionService.createMissionPairMatching(Part.FRONT_END, "자동차경주");

        Mission racing = missionRepository.findByName("자동차경주", Part.FRONT_END).get();

        Assertions.assertThat(missionRepository.isMatched(racing)).isEqualTo(true);
    }

    @Test
    void deleteAllTest() {
        missionService.deleteAll();
        Assertions.assertThat(missionRepository.findAllMissions().size()).isEqualTo(0);
    }

    @Test
    void getMissionsByLevelTest() {
        List<Mission> missionsByLevel = missionService.getMissionsByLevel(Level.TWO, Part.FRONT_END);

        Assertions.assertThat(missionsByLevel.size()).isEqualTo(3);
    }

    @Test
    void getByName() {
    }

    @DisplayName("초기화 기능 테스트")
    @Test
    void init() {
        missionService.init();
        Assertions.assertThat(missionRepository.findAllMissions().size()).isEqualTo(16);
    }
}
