package pairmatching.repository.missionrepository;

import pairmatching.domain.Level;
import pairmatching.domain.Mission;

import java.util.*;
import java.util.stream.Collectors;

public class MemoryMissionRepository implements MissionRepository {

    private final Map<Mission, Boolean> missions = new HashMap<>();

    @Override
    public void save(Mission mission) {
        missions.replace(mission, true);
    }

    @Override
    public void deleteAll() {
        missions.clear();
    }

    @Override
    public List<Mission> findAllMatchedByLevel(Level level) {
        return missions.keySet().stream()
                .filter(missions::get)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Mission> findByName(String missionName) {
        return missions.keySet()
                .stream().filter(mission -> mission.getName().equals(missionName))
                .findAny();
    }

    public List<Mission> findAllMissions() {
        return new ArrayList<>(missions.keySet());
    }
}
