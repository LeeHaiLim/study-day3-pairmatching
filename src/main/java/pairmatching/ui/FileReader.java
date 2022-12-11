package pairmatching.ui;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
    public static List<String> readBackCrew() {
        try (Stream<String> lines =
                     Files.lines(Paths.get("/Users/imjongho/study-day3-pairmatching/src/main/resources/backend-crew.md"),
                             Charset.defaultCharset())) {
            return lines.flatMap(line -> Arrays.stream(line.split("\n")))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new IllegalArgumentException("[ERROR] ");
        }
    }

    public static List<String> readFrontCrew() {
        return null;
    }
}
