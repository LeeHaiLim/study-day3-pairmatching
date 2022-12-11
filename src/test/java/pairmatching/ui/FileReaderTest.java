package pairmatching.ui;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FileReaderTest {

    @DisplayName("백엔드 크루 파일 읽어오기 테스트")
    @Test
    void readBackFileTest() {
        List<String> strings = FileReader.readBackCrew();

        Assertions.assertThat(strings.size()).isEqualTo(20);
    }

    @DisplayName("프론트엔드 크루 파일 읽어오기 테스트")
    @Test
    void readFrontFileTest() {
        List<String> strings = FileReader.readFrontCrew();

        Assertions.assertThat(strings.size()).isEqualTo(15);
    }
}
