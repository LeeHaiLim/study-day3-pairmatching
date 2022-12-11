package pairmatching.model;

import pairmatching.Const;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CrewReader {
    private List<String> crewNames = new ArrayList<>();

    public void readCrews(Course course) {
        String filePath = "";
        if (course.equals(Course.BACKEND)) {
            filePath = Const.BACKEND_PATH;
        }
        if (course.equals(Course.FRONTEND)) {
            filePath = Const.FRONTEND_PATH;
        }
        File file = new File(filePath);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String name;
            while((name = reader.readLine())!= null) {
                crewNames.add(name);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public List<String> getCrews() {
        return crewNames;
    }
}
