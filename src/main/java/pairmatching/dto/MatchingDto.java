package pairmatching.dto;

import java.util.List;

public class MatchingDto {

    private final List<List<String>> pairs;

    public MatchingDto(List<List<String>> pairs) {
        this.pairs = pairs;
    }

    public List<List<String>> getPairs() {
        return pairs;
    }
}
