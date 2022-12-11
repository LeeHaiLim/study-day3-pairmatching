package pairmatching.repository.pairmatchingrepository;

import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.domain.Part;

import java.util.Optional;

public interface PairMatchingRepository {
    Optional<Pair> findPairByMission(Mission mission);

    Pair save(Pair pair);

    void deleteAll();
}
