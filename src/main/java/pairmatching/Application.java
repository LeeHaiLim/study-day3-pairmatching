package pairmatching;

import pairmatching.controller.PairMatchingController;
import pairmatching.domain.BackMember;
import pairmatching.domain.FrontMember;
import pairmatching.repository.missionrepository.MemoryMissionRepository;
import pairmatching.repository.missionrepository.MissionRepository;
import pairmatching.repository.pairmatchingrepository.MemoryPairMatchingRepository;
import pairmatching.repository.pairmatchingrepository.PairMatchingRepository;
import pairmatching.service.MissionService;
import pairmatching.service.PairMatchingService;
import pairmatching.ui.FileReader;

public class Application {
    public static void main(String[] args) {
        MissionRepository missionRepository = new MemoryMissionRepository();
        PairMatchingRepository pairMatchingRepository = new MemoryPairMatchingRepository();
        MissionService missionService = new MissionService(missionRepository);
        PairMatchingService pairMatchingService = new PairMatchingService(
                missionRepository, pairMatchingRepository,
                new BackMember(FileReader.readBackCrew()), new FrontMember(FileReader.readFrontCrew())
        );

        PairMatchingController pairMatchingController =
                new PairMatchingController(pairMatchingService, missionService);
        pairMatchingController.run();
    }
}
