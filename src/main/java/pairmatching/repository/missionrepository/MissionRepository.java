package pairmatching.repository.missionrepository;

import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Part;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public interface MissionRepository {
    void save(Mission mission);

    void deleteAll();

    List<Mission> findAllMatchedByLevel(Level level, Part part);

    Optional<Mission> findByName(String missionName, Part part);

    void init(List<Mission> missions);

    List<Mission> findAllMissions();

    boolean isMatched(Mission mission);
}
