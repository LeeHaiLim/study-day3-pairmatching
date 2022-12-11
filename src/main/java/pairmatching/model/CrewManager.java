package pairmatching.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class CrewManager {

    List<String> backEndCrewNames;
    List<Crew> shuffledBackEndCrews;
    List<String> frontEndCrewNames;
    List<Crew> shuffledFrontEndCrews;

    public void readCrews() {
        CrewReader crewReader = new CrewReader();
        crewReader.readCrews(Course.BACKEND);
        backEndCrewNames = crewReader.getCrews();
        crewReader.readCrews(Course.FRONTEND);
        frontEndCrewNames = crewReader.getCrews();
    }

    public void shuffledCrews() {
        for (String name : Randoms.shuffle(backEndCrewNames)) {
            shuffledBackEndCrews.add(new Crew(Course.BACKEND, name));
        }
        for (String name : Randoms.shuffle(frontEndCrewNames)) {
            shuffledFrontEndCrews.add(new Crew(Course.FRONTEND, name));
        }
    }

    public List<Pair> matchPair(List<Crew> crews) {
        List<Pair> pairs = null;
        for (int i = 0; i < crews.size(); i += 2) {
            pairs.add(new Pair(crews.get(i), crews.get(i + 1)));
            if (canNotBeDiveded(crews, pairs, i)) break;
        }
        return pairs;
    }

    private boolean canNotBeDiveded(List<Crew> crews, List<Pair> pairs, int i) {
        if (!isDivided(crews)) {
            if (i == crews.size() - 1) {
                pairs.add(new Pair(crews.get(i), crews.get(i + 1), crews.get(i + 2)));
                return true;
            }
        }
        return false;
    }

    private boolean isDivided(List<Crew> crews) {
        if (crews.size() % 2 == 0) {
            return true;
        }
        return false;
    }

    // 같은 레벨에서 페어로 만난 적 있는 크루끼리 페어로 매칭되었는지 검증해주는 함수 추가
    public boolean checkReUnion() {


        return true;
    }

    public List<Pair> reMatch(List<Crew> crews) {
        shuffledCrews();
        return matchPair(crews);
    }

    public List<Crew> getShuffledBackEndCrews() {
        return shuffledBackEndCrews;
    }

    public List<Crew> getShuffledFrontEndCrews() {
        return shuffledFrontEndCrews;
    }
}
