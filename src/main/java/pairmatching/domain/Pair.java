package pairmatching.domain;

import java.util.List;
import java.util.Objects;

public class Pair {
    private final List<String> crewNames;

    public Pair(List<String> crews) {
        this.crewNames = crews;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Pair pair = (Pair) o;

        return crewNames.stream().filter(pair.crewNames::contains).count() >= 2;
    }

    @Override
    public int hashCode() {
        return Objects.hash(crewNames);
    }

    public List<String> getCrewNames() {
        return crewNames;
    }
}
