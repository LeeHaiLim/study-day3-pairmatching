package pairmatching.domain;

import java.util.List;

public class Pair {
    private final List<List<String>> names;
    private final Part part;
    private final Mission mission;

    public Pair(List<List<String>> names, Part part, Mission mission) {
        this.names = names;
        this.part = part;
        this.mission = mission;
    }
}
