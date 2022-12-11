package pairmatching.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

class CrewSaveServiceTest {
    private CrewSaveService crewSaveService = new CrewSaveService();

    @DisplayName("백엔드 크루 출력 테스트")
    @Test
    void getBackendCrew() {
        List<String> backendCrew = crewSaveService.getBackendCrew();
        Assertions.assertThat(backendCrew.size()).isEqualTo(20);
    }

    @DisplayName("프론트엔드 크루 출력 테스트")
    @Test
    void getFrontendCrew() {
        List<String> frontendCrew = crewSaveService.getFrontendCrew();
        Assertions.assertThat(frontendCrew.size()).isEqualTo(15);
    }
}