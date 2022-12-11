package pairmatching.domain;

import java.util.Arrays;

public enum MainFunction {
    MATCHING("1"),
    SEARCHING("2"),
    INIT("3"),
    QUIT("Q");

    private final String mainFunctionInput;

    MainFunction(String mainFunctionInput) {
        this.mainFunctionInput = mainFunctionInput;
    }

    public static MainFunction from(String input) {
        return Arrays.stream(MainFunction.values())
                .filter(main -> main.mainFunctionInput.equals(input))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR]"));
    }
}
