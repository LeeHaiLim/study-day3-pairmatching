package pairmatching.repository.pairmatchingrepository;

import pairmatching.domain.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryPairMatchingRepository implements PairMatchingRepository {

    private final List<Pair> pairs = new ArrayList<>();

    @Override
    public Optional<Pair> findPairByMission() {
        return Optional.empty();
    }

    @Override
    public Pair save(Pair pair) {
        pairs.add(pair);
        return pair;
    }

    @Override
    public void deleteAll() {

    }
}
