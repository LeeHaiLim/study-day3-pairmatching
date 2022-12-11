package pairmatching.repository.missionrepository;

import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Part;

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
    public List<Mission> findAllMatchedByLevel(Level level, Part part) {
        return missions.keySet().stream()
                .filter(mission -> mission.getPart().equals(part) && mission.getLevel().equals(level))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<Mission> findByName(String missionName,Part part) {
        return missions.keySet()
                .stream().filter(mission ->
                        mission.getName().equals(missionName) && mission.getPart().equals(part))
                .findAny();
    }

    @Override
    public List<Mission> findAllMissions() {
        return new ArrayList<>(missions.keySet());
    }

    @Override
    public void init(List<Mission> missions) {
        for (Mission mission : missions) {
            this.missions.put(mission, false);
        }
    }

    @Override
    public boolean isMatched(Mission mission) {
        return this.missions.get(mission);
    }
}
