package pairmatching.helper;

import pairmatching.constant.Course;
import pairmatching.domain.Crew;
import pairmatching.exception.ErrorMessage;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CrewReader {

    private static final String FOLDER_PATH = System.getProperty("user.dir");
    private static final String FILE_PATH = FOLDER_PATH + "\\src\\main\\resources\\";
    private static final String BACKEND_FILE_NAME = "backend-crew.md";
    private static final String FRONTEND_FILE_NAME = "frontend-crew.md";

    public static List<Crew> readBackendCrews() {
        Scanner scanner = setScannerByFilePath(FILE_PATH + BACKEND_FILE_NAME);
        return setCrewsForm(scanner);
    }

    private static Scanner setScannerByFilePath(String filePath) {
        try {
            return new Scanner(new File(filePath));
        } catch (FileNotFoundException exception) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_FILE_PATH.getMessage());
        }
    }

    private static List<Crew> setCrewsForm (Scanner scanner) {
        List<Crew> crews = new ArrayList<>();

        while (scanner.hasNextLine()) {
            String name = scanner.nextLine();
            System.out.println(name);
            crews.add(new Crew(name, Course.BACKEND));
        }
        return crews;
    }
}
