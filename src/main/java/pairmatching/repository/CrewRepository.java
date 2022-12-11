package pairmatching.repository;

import pairmatching.domain.Crew;
import pairmatching.helper.CrewReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CrewRepository {

    private final List<Crew> backendCrews = new ArrayList<>();
    private final List<Crew> frontendCrews = new ArrayList<>();

    CrewRepository() {
        initializeRepository();
    }

    private void initializeRepository() {
        backendCrews.addAll(CrewReader.readBackendCrews());
        frontendCrews.addAll(CrewReader.readFrontendCrews());
    }

    private List<Crew> getBackendCrews() {
        return Collections.unmodifiableList(backendCrews);
    }

    private List<Crew> getFrontendCrews() {
        return Collections.unmodifiableList(frontendCrews);
    }
}
