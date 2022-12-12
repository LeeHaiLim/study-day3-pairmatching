package pairmatching.repository;

import pairmatching.domain.Crew;
import pairmatching.domain.menu.Course;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CrewRepository {
    private static final List<Crew> crews = new ArrayList<>();

    public void addCrew(Crew crew) {
        crews.add(crew);
    }

    public List<String> getCrewsByCourse(Course course) {
        if (course == Course.BACKEND) {
            return getBackendCrews();
        }
        return getFrontendCrews();
    }

    private List<String> getBackendCrews() {
        return crews.stream()
                .filter(crew -> crew.isBackendCrew())
                .map(Crew::getName)
                .collect(Collectors.toList());
    }

    private List<String> getFrontendCrews() {
        return crews.stream()
                .filter(crew -> crew.isFrontendCrew())
                .map(Crew::getName)
                .collect(Collectors.toList());
    }
}