package pairmatching.constant;

import pairmatching.domain.Crew;
import pairmatching.exception.ErrorMessage;
import java.util.List;

public class Pair {

    private final List<Crew> crews;

    Pair(List<Crew> crews) {
        validateCrews(crews);
        this.crews = crews;
    }

    private void validateCrews(List<Crew> crews) {
        if (crews.size() < 2 || crews.size() > 3) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_PAIR.getMessage());
        }
    }


}
