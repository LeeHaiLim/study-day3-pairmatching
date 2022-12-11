package pairmatching.domain;

import pairmatching.exception.ErrorMessage;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Pair {

    private final List<Crew> crews;

    public Pair(List<Crew> crews) {
        validateCrews(crews);
        this.crews = crews;
    }

    private void validateCrews(List<Crew> crews) {
        if (crews.size() < 2 || crews.size() > 3) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_PAIR.getMessage());
        }
    }

    public boolean isPairOverlapped(List<Pair> pairs) {
        for (Pair comparedPair : pairs) {
            if (isPairOverlapped(comparedPair)) {
                return true;
            }
        }
        return false;
    }

    public boolean isPairOverlapped(Pair pair) {
        List<Crew> comparedCrews = pair.getCrews();
        return comparedCrews.stream()
                .map(comparedCrew -> this.crews.contains(comparedCrew))
                .filter(isContain -> isContain)
                .count() >= 2;
    }

    public List<String> getPairDto() {
        return crews.stream()
                .map(crew -> crew.getName())
                .collect(Collectors.toList());
    }

    public List<Crew> getCrews() {
        return Collections.unmodifiableList(crews);
    }
}
