package pairmatching.repository.pairmatchingrepository;

import pairmatching.domain.Pair;

import java.util.Optional;

public class MemoryPairMatchingRepository implements PairMatchingRepository {

    @Override
    public Optional<Pair> findPairByMission() {
        return Optional.empty();
    }

    @Override
    public Pair save() {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
