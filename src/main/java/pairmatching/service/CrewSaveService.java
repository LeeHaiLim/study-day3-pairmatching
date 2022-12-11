package pairmatching.service;

import pairmatching.domain.Course;
import pairmatching.domain.Crew;
import pairmatching.repository.CrewRepository;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CrewSaveService {
    private CrewRepository crewRepository = new CrewRepository();

    public List<String> getBackendCrew() {
        File file = new File("src/main/resources/backend-crew.md");
        return readCrewInfo(file);
    }

    public List<String> getFrontendCrew() {
        File file = new File("src/main/resources/frontend-crew.md");
        return readCrewInfo(file);
    }

    public void saveCrewNames(List<String> crewNames, Course course) {
        crewNames.stream()
                .map(name -> Crew.of(course, name))
                .forEach(crewRepository::addCrew);
    }

    public List<String> readCrewInfo(File file) {
        List<String> crewNames = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String name;
            while ((name = reader.readLine()) != null) {
                crewNames.add(name);
            }
            reader.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return crewNames;
    }
}