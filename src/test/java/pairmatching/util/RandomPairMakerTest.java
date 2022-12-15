package pairmatching.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import pairmatching.domain.MissionGroup;
import pairmatching.domain.Pair;
import pairmatching.service.CrewSaveService;

import java.util.List;

class RandomPairMakerTest {
    private CrewSaveService crewSaveService = new CrewSaveService();

    @Test
    void getRandomPair() {
        MissionGroup lotto = MissionGroup.of(List.of("프론트엔드", "레벨1", "로또"));
        List<String> crews = crewSaveService.getFrontendCrew();
        List<Pair> randomPair = RandomPairMaker.getRandomPair(lotto, crews);
        Assertions.assertThat(randomPair.size()).isEqualTo(crews.size() / 2);
    }
}