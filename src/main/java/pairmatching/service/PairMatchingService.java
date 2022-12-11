package pairmatching.service;

import pairmatching.domain.*;
import pairmatching.repository.missionrepository.MissionRepository;
import pairmatching.repository.pairmatchingrepository.PairMatchingRepository;

import java.util.List;
import java.util.Optional;

public class PairMatchingService {
    private final MissionRepository missionRepository;
    private final PairMatchingRepository pairMatchingRepository;
    private final BackMember backMember;
    private final FrontMember frontMember;

    public PairMatchingService(
            MissionRepository missionRepository,
            PairMatchingRepository pairMatchingRepository,
            BackMember backMember, FrontMember frontMember) {
        this.missionRepository = missionRepository;
        this.pairMatchingRepository = pairMatchingRepository;
        this.backMember = backMember;
        this.frontMember = frontMember;
    }

    public Pair createPairs(Part part, String missionName) {
        Mission mission = missionRepository.findByName(missionName, part)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR]"));

        List<List<String>> pairs = getPairs(part);

        Pair pair = new Pair(pairs, part, mission);
        //중복 검증과정 필요
        return pairMatchingRepository.save(pair);
    }

    public Pair findPair(Part part,String missionName) {
        Mission mission = missionRepository.findByName(missionName, part)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR]"));

        return pairMatchingRepository.findPairByMission(mission)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR]"));
    }

    public void initPair() {

    }

    private List<List<String>> getPairs(Part part) {
        if (part.equals(Part.FRONT_END)) {
            return frontMember.getPair();
        }
        return backMember.getPair();
    }
}
