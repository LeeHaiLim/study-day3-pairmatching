package pairmatching.view.output;

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

    public void printMissions() {
        print(INTRODUCING_FUNCTION);
    }

    public void printFinishedInitializing() {
        
    }

    public void printMatchingResult() {

    }

    private void print(String message) {
        System.out.println(message);
    }
}
