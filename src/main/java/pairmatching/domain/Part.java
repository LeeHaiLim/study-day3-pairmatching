package pairmatching.domain;

import java.util.Arrays;

public enum Part {
    FRONT_END("프론트엔드"),
    BACK_END("백엔드");

    private final String partName;

    Part(String partName) {
        this.partName = partName;
    }

    public static Part from(String partInput) {
        return Arrays.stream(Part.values())
                .filter(part -> part.partName.equals(partInput))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR]"));
    }
}
