package pairmatching.view.output;

import pairmatching.dto.MatchingDto;
import java.util.List;
import java.util.stream.Collectors;

public class OutputView {

    private static final String INTRODUCING_FUNCTION =
            "\n#############################################\n" +
            "과정: 백엔드 | 프론트엔드\n" +
            "미션:\n" +
            "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" +
            "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" +
            "  - 레벨3: \n" +
            "  - 레벨4: 성능개선 | 배포\n" +
            "  - 레벨5: \n" +
            "############################################";
    private static final String INITIALIZING_FINISH =
            "\n초기화 되었습니다. ";
    private static final String PAIR_MATCHING_RESULT =
            "\n페어 매칭 결과입니다.";
    private static final String PAIR_DELIMITER = " : ";

    public void printMissions() {
        print(INTRODUCING_FUNCTION);
    }

    public void printFinishedInitializing() {
        print(INITIALIZING_FINISH);
    }

    public void printErrorMessage(Exception exception) {
        print(exception.getMessage());
    }

    public void printMatchingResult(MatchingDto dto) {
        print(PAIR_MATCHING_RESULT);
        for (List<String> pair : dto.getPairs()) {
            printPair(pair);
        }
    }

    private void printPair(List<String> pair) {
        String message = pair.stream()
                .collect(Collectors.joining(PAIR_DELIMITER));
        print(message);
    }

    private void print(String message) {
        System.out.println(message);
    }
}
