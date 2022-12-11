package pairmatching.repository.pairmatchingrepository;

import pairmatching.domain.Mission;
import pairmatching.domain.Pair;
import pairmatching.domain.Part;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MemoryPairMatchingRepository implements PairMatchingRepository {

    private final List<Pair> pairs = new ArrayList<>();

    @Override
    public Optional<Pair> findPairByMission(Mission mission) {
        return pairs.stream()
                .filter(pair -> pair.getMission().equals(mission))
                .findAny();
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
