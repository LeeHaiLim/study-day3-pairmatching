package pairmatching.repository.missionrepository;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pairmatching.domain.Level;
import pairmatching.domain.Mission;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MemoryMissionRepositoryTest {
    MissionRepository missionRepository;

    @BeforeEach
    void setUp() {
        missionRepository = new MemoryMissionRepository();
        Mission mission1 = new Mission("test1", Level.ONE);
        Mission mission2 = new Mission("test2", Level.TWO);
        Mission mission3 = new Mission("test3", Level.TWO);
        List<Mission> missions = Arrays.asList(mission1, mission2, mission3);
        missionRepository.init(missions);
    }


    @DisplayName("미션 저장 테스트")
    @Test
    void save() {
        Optional<Mission> test1 = missionRepository.findByName("test1");

        missionRepository.save(test1.get());

        Assertions.assertThat(missionRepository.findAllMatchedByLevel(Level.ONE).size()).isEqualTo(1);
    }

    @DisplayName("미션 삭제 테스트")
    @Test
    void deleteAll() {
        missionRepository.deleteAll();

        Assertions.assertThat(missionRepository.findAllMissions().size()).isEqualTo(0);
    }

    @DisplayName("레벨로 미션 조회 테스트")
    @Test
    void findAllMatchedByLevel() {
        Optional<Mission> test2 = missionRepository.findByName("test2");
        Optional<Mission> test3 = missionRepository.findByName("test3");

        missionRepository.save(test2.get());
        missionRepository.save(test3.get());

        Assertions.assertThat(missionRepository.findAllMatchedByLevel(Level.TWO).size()).isEqualTo(2);
    }

    @DisplayName("이름으로 조회 테스트")
    @Test
    void findByName() {
        Assertions.assertThat(missionRepository.findByName("test1").get().getLevel())
                .isEqualTo(Level.ONE);
    }

    @DisplayName("전체 미션 조회 테스트")
    @Test
    void findAllMissions() {
        Assertions.assertThat(missionRepository.findAllMissions().size()).isEqualTo(3);
    }
}
