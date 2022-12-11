package pairmatching.repository.missionrepository;

import pairmatching.domain.Level;
import pairmatching.domain.Mission;

import java.util.List;
import java.util.Optional;

public interface MissionRepository {
    void save(Mission mission);

    void deleteAll();

    List<Mission> findAllMatchedByLevel(Level level);

    Optional<Mission> findByName(String missionName);
}
