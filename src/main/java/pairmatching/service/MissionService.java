package pairmatching.service;

import pairmatching.domain.Mission;
import pairmatching.repository.missionrepository.MemoryMissionRepository;
import pairmatching.repository.missionrepository.MissionRepository;

import java.util.List;
import java.util.Optional;

public class MissionService {

    private final MissionRepository missionRepository;

    public MissionService(MemoryMissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public void createMission() {

    }

    public void deleteAll() {

    }

    public List<Mission> getMissionsByLevel() {
        return null;
    }

    public Optional<Mission> getByName() {
        return Optional.empty();
    }
}
