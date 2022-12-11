package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import pairmatching.domain.Crew;
import pairmatching.domain.Pair;
import pairmatching.domain.PairKey;
import pairmatching.repository.CrewRepository;
import pairmatching.repository.PairRepository;

public class PairMatcher {
    public static void pairMatch(PairKey pairKey) {
        List<Pair> existedPair = PairRepository.getPairsByCourseAndLevel(pairKey.getCourse(), pairKey.getLevel());
        List<String> crewNames = CrewRepository.getCrewsByCourse(pairKey.getCourse()).stream()
                .map(Crew::getName)
                .collect(Collectors.toList());
        if (crewNames.size() < 2) {
            throw new IllegalArgumentException("페어를 만들 수 없습니다.");
        }
        int trial = 0;
        while (true) {
            List<Pair> temp = makePairs(crewNames);
            if (temp.stream().noneMatch(existedPair::contains)) {
                PairRepository.addPairs(pairKey, temp);
                break;
            }
            trial++;
            if (trial == 3) {
                throw new IllegalArgumentException("3번 이상 매칭에 실패했습니다.");
            }
        }
    }

    private static List<Pair> makePairs(List<String> crewNames) {
        List<String> shuffledCrewNames = Randoms.shuffle(crewNames);
        List<Pair> pairs = new ArrayList<>();

        for (int i = 0; i < shuffledCrewNames.size() - 1; i += 2) {
            int toIndex = i + 2;
            if (i + 2 == shuffledCrewNames.size() - 1) {
                toIndex = shuffledCrewNames.size();
            }
            pairs.add(new Pair(shuffledCrewNames.subList(i, toIndex)));
        }

        return pairs;
    }
}
