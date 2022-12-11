package pairmatching.helper;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.domain.Crew;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CrewShuffler {

    public static List<Crew> shuffle(List<Crew> crews) {
        Map<String, Crew> nameToCrew = setNameToCrew(crews);

        List<String> names = crews.stream().map(Crew::getName)
                .collect(Collectors.toList());
        List<String> shuffledNames = Randoms.shuffle(names);

        return shuffledNames.stream()
                .map(name -> nameToCrew.get(name))
                .collect(Collectors.toList());
    }

    private static Map<String, Crew> setNameToCrew(List<Crew> crews) {
        Map<String, Crew> nameToCrew = new HashMap<>();
        for (Crew crew : crews) {
            nameToCrew.put(crew.getName(), crew);
        }
        return nameToCrew;
    }
}
