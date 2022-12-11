package pairmatching.ui;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    private static final String BACK_END_FILE_PATH = "/Users/imjongho/study-day3-pairmatching/src/main/resources/backend-crew.md";
    private static final String FRONT_END_FILE_PATH = "/Users/imjongho/study-day3-pairmatching/src/main/resources/frontend-crew.md";


    public static List<String> readBackCrew() {
        return readFile(BACK_END_FILE_PATH);
    }

    public static List<String> readFrontCrew() {
        return readFile(FRONT_END_FILE_PATH);
    }

    private static List<String> readFile(String path) {
        try (Stream<String> lines =
                     Files.lines(Paths.get(path), Charset.defaultCharset())) {
            return lines.flatMap(line -> Arrays.stream(line.split("\n")))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException("[ERROR] ");
        }
    }
}
