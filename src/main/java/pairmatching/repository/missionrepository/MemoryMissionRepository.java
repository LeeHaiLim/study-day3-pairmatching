package pairmatching.repository.missionrepository;

import pairmatching.domain.Mission;

import java.util.List;
import java.util.Optional;

public class MemoryMissionRepository implements MissionRepository {
    @Override
    public void save() {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Mission> findAllByLevel() {
        return null;
    }

    @Override
    public Optional<Mission> findByName() {
        return Optional.empty();
    }
}
