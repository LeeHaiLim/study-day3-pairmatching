package pairmatching.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.repository.missionrepository.MemoryMissionRepository;
import pairmatching.repository.missionrepository.MissionRepository;

import static org.junit.jupiter.api.Assertions.*;

class MissionServiceTest {

    MissionService missionService;
    MissionRepository missionRepository;

    @BeforeEach
    void setUp() {
        missionRepository = new MemoryMissionRepository();
        missionService = new MissionService(missionRepository);
    }

    @Test
    void createMission() {
    }

    @Test
    void deleteAll() {
    }

    @Test
    void getMissionsByLevel() {
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
