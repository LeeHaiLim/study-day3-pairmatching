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

    public Pair createPairs(Part part, String missionName) throws IllegalArgumentException {
        Mission mission = missionRepository.findByName(missionName, part)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR]"));

        List<List<String>> pairs = getPairs(part);

        Pair pair = new Pair(pairs, part, mission);
        duplicated(mission.getLevel(), part, pairs);
        return pairMatchingRepository.save(pair);
    }

    public Pair findPair(Part part, String missionName) {
        Mission mission = missionRepository.findByName(missionName, part)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR]"));

        return pairMatchingRepository.findPairByMission(mission)
                .orElseThrow(() -> new IllegalArgumentException("[ERROR]"));
    }

    public void deletePair() {
        pairMatchingRepository.deleteAll();
    }

    private List<List<String>> getPairs(Part part) {
        if (part.equals(Part.FRONT_END)) {
            return frontMember.getPair();
        }
        return backMember.getPair();
    }

    private void duplicated(Level level, Part part, List<List<String>> pairs) {
        List<Mission> allMatchedByLevel = missionRepository.findAllMatchedByLevel(level, part);
        for (Mission mission : allMatchedByLevel) {
            Pair pair = findPair(part, mission.getName());
            List<List<String>> names = pair.getNames();
            Optional<List<String>> any = pairs.stream().filter(names::contains)
                    .findAny();
            if (any.isPresent()) {
                throw new IllegalArgumentException("[ERROR] 같은 레벨 내에 동일한 매칭이 존재합니다.");
            }
        }
    }
}
