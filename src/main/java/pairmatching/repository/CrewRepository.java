package pairmatching.repository;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import pairmatching.domain.Course;
import pairmatching.domain.Crew;

public class CrewRepository {
    private static Map<Course, List<Crew>> crews = new EnumMap<>(Course.class);

    public static void addCrew(Course course, String crewName) {
        crews.putIfAbsent(course, new ArrayList<>());
        crews.get(course).add(new Crew(course, crewName));
    }

    public static List<Crew> getCrewsByCourse(Course course) {
        return crews.get(course);
    }
}
