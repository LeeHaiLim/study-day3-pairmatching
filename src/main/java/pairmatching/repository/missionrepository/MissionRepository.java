package pairmatching.repository.missionrepository;

import pairmatching.domain.Mission;

import java.util.List;
import java.util.Optional;

public interface MissionRepository {
    void save();

    void deleteAll();

    List<Mission> findAllByLevel();

    Optional<Mission> findByName();
}
