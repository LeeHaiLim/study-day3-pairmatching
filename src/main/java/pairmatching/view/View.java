package pairmatching.view;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.model.Crew;
import pairmatching.model.Pair;

import java.util.List;
import java.util.StringJoiner;

public class View {

    private static final String MAIN_MENU = "#############################################\n" +
            "과정: 백엔드 | 프론트엔드\n" +
            "미션:\n" +
            "  - 레벨1: 자동차경주 | 로또 | 숫자야구게임\n" +
            "  - 레벨2: 장바구니 | 결제 | 지하철노선도\n" +
            "  - 레벨3: \n" +
            "  - 레벨4: 성능개선 | 배포\n" +
            "  - 레벨5: \n" +
            "############################################\n" +
            "과정, 레벨, 미션을 선택하세요.\n" +
            "ex) 백엔드, 레벨1, 자동차경주";
    private static final String SELECT_FEATURE = "기능을 선택하세요.\n" +
            "1. 페어 매칭\n" +
            "2. 페어 조회\n" +
            "3. 페어 초기화\n" +
            "Q. 종료";

    private static final String PAIR_MATCHING_RESULT = "페어 매칭 결과입니다.";
    private static final String REMATCH = "매칭 정보가 있습니다. 다시 매칭하시겠습니까?\n" +
            "네 | 아니오";
    private static final String INIT = "초기화 되었습니다.";

    public String selectFeature() {
        System.out.println(SELECT_FEATURE);
        return Console.readLine();
    }

    public String selectMenu() {
        System.out.println(MAIN_MENU);
        return Console.readLine();
    }

    public void printPairs(List<Pair> pairs) {
        System.out.println(PAIR_MATCHING_RESULT);
        for(Pair pair : pairs) {
            StringJoiner stringJoiner = new StringJoiner(" : ");
            for(Crew crew : pair.getPairs()) {
                stringJoiner.add(crew.getName());
            }
            System.out.println(stringJoiner.toString());
        }
    }

    public String askRematch() {
        System.out.println(REMATCH);
        return Console.readLine();
    }

}
