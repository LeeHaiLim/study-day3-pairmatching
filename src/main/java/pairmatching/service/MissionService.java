package pairmatching.service;

import pairmatching.domain.Level;
import pairmatching.domain.Mission;
import pairmatching.domain.Part;
import pairmatching.repository.missionrepository.MemoryMissionRepository;
import pairmatching.repository.missionrepository.MissionRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MissionService {

    private final MissionRepository missionRepository;

    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public void createMissionPairMatching(Part part, String missionName) {
        Optional<Mission> mission = missionRepository.findByName(missionName, part);
        if (!mission.isPresent()) {
            throw new IllegalArgumentException("[ERROR]");
        }
        missionRepository.save(mission.get());
    }

    public void deleteAll() {
        missionRepository.deleteAll();
    }

    public List<Mission> getMissionsByLevel() {
        return null;
    }

    public Optional<Mission> getByName() {
        return Optional.empty();
    }

    public void init() {
        missionRepository.init(initMissions(Part.BACK_END));
        missionRepository.init(initMissions(Part.FRONT_END));
    }

    private List<Mission> initMissions(Part part) {
        Mission mission1 = new Mission("자동차경주", Level.ONE, part);
        Mission mission2 = new Mission("로또", Level.ONE, part);
        Mission mission3 = new Mission("숫자야구게임", Level.ONE, part);
        Mission mission4 = new Mission("장바구니", Level.TWO, part);
        Mission mission5 = new Mission("결제", Level.TWO, part);
        Mission mission6 = new Mission("지하철노선도", Level.TWO, part);
        Mission mission7 = new Mission("성능개선", Level.FOUR, part);
        Mission mission8 = new Mission("배포", Level.FOUR, part);
        return Arrays.asList(mission1, mission2, mission3, mission4, mission5, mission6, mission7, mission8);
    }
}
