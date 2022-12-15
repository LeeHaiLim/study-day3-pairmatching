package pairmatching.dto;

import pairmatching.domain.Pair;

import java.util.ArrayList;
import java.util.List;

public class MatchResultDto {
    private final List<Pair> matchResult;

    private MatchResultDto(List<Pair> matchResult) {
        this.matchResult = matchResult;
    }

    public static MatchResultDto from(List<Pair> matchResult) {
        return new MatchResultDto(matchResult);
    }

    public List<String> getMatchResult() {
        List<String> result = new ArrayList<>();
        matchResult.stream().map(Pair::getPair)
                .forEach(names -> result.add(String.join(" : ", names)));
        return result;
    }
}