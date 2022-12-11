package pairmatching;

import static pairmatching.domain.Course.FRONTEND;
import static pairmatching.domain.Course.BACKEND;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import pairmatching.domain.Course;
import pairmatching.repository.CrewRepository;

public class Initiator {
    public static void init() {
        try {
            readFile("src/main/resources/backend-crew.md", BACKEND);
            readFile("src/main/resources/frontend-crew.md", FRONTEND);
        } catch (IOException e) {
            throw new IllegalArgumentException("파일 입출력 오류 : " + e.getMessage());
        }
    }

    public static void readFile(String fileName, Course course) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        while (true) {
            String line = reader.readLine();
            if (line == null) {
                break;
            }
            CrewRepository.addCrew(course, line);
        }
        reader.close();
    }
}
