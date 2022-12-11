package pairmatching.repository.pairmatchingrepository;

import pairmatching.domain.Pair;

import java.util.Optional;

public interface PairMatchingRepository {
    Optional<Pair> findPairByMission();

    Pair save();

    void deleteAll();
}
