package pairmatching.repository;

import pairmatching.domain.Crew;
import pairmatching.helper.CrewReader;
import java.util.ArrayList;
import java.util.List;

public class CrewRepository {

    private final List<Crew> backendCrew = new ArrayList<>();
    private final List<Crew> frontendCrew = new ArrayList<>();

    CrewRepository() {
        initializeRepository();
    }

    private final void initializeRepository() {
        backendCrew.addAll(CrewReader.readBackendCrews());
        frontendCrew.addAll(CrewReader.readFrontendCrews());
    }
}
