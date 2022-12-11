package reader;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileReaderTest {

    @Test
    void fileReadTest() throws FileNotFoundException {
        String path = System.getProperty("user.dir") + "\\src\\main\\resources\\";
        Scanner scanner = new Scanner(new File( path + "frontend-crew.md"));

        while (scanner.hasNextLine()) {
            String str = scanner.nextLine();
            System.out.println(str);
        }
    }
}
