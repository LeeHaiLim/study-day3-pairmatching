package pairmatching;

import java.io.*;
import java.util.List;

public class CrewReader {
    List<Crew> crews;

    public void readCrews(Course course) {
        String filePath = "D:\\study\\study-day3-pairmatching\\src\\main\\resources\\";
        if (course.equals(Course.BACKEND)) {
            filePath += "backend-crew.md";
        }
        if (course.equals(Course.FRONTEND)) {
            filePath += "frontend-crew.md";
        }
        File file = new File(filePath);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String name;
            while((name = reader.readLine())!= null) {
                crews.add(new Crew(course, name));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Crew> getCrews() {
        return crews;
    }
}
