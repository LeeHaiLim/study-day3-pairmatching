package pairmatching;

import camp.nextstep.edu.missionutils.Randoms;
import pairmatching.model.*;

import java.util.List;

public class PairMatcher {

    List<String> CrewNames;
    List<Crew> shuffledCrews;
    List<Pair> pairs;

    Course course;
    Level level;

    public PairMatcher(Course course, Level level) {
        validateInfo(course, level);
        this.course = course;
        this.level = level;
    }

    private void validateInfo(Course course, Level level) {
        if(course == null) {
            throw new IllegalArgumentException("[ERROR] 해당 코스는 존재하지 않습니다.");
        }
        if(level == null) {
            throw new IllegalArgumentException("[ERROR] 해당 레벨은 존재하지 않습니다.");
        }
    }

    public void readCrews() {
        CrewReader crewReader = new CrewReader();
        crewReader.readCrews(course);
        CrewNames = crewReader.getCrews();
    }

    public void shuffledCrews() {
        for (String name : Randoms.shuffle(CrewNames)) {
            shuffledCrews.add(new Crew(course, name));
        }
    }

    public List<Pair> matchPair() {
        for (int i = 0; i < shuffledCrews.size(); i += 2) {
            pairs.add(new Pair(shuffledCrews.get(i), shuffledCrews.get(i + 1)));
            if (canNotBeDiveded(shuffledCrews, pairs, i)) break;
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

    public List<Pair> match() {
        shuffledCrews();
        return matchPair();
    }


    public void initPair() {
        pairs.clear();
    }

    public boolean isExist() {
        if(pairs.size() != 0) {
            return true;
        }
        return false;
    }

    public List<Pair> getPairs() {
        return pairs;
    }
}
