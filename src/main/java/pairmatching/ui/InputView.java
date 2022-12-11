package pairmatching.ui;

import camp.nextstep.edu.missionutils.Console;
import pairmatching.domain.MainFunction;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class InputView {
    private static final String RETRY_INPUT = "네";
    private static final String NOT_RETRY_INPUT = "아니오";

    public static MainFunction insertMainFunctionInput() {
        return repeat(() -> MainFunction.from(Console.readLine()));
    }

    public static List<String> insertDetails() {
        try {
            String line = Console.readLine();
            return new ArrayList<>(Arrays.asList(line.split(", ")));
        } catch (Exception e) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    public static boolean insertReMatchingOrNot() {
        String reMatchingInput = Console.readLine();
        if (!reMatchingInput.equals(RETRY_INPUT) && !reMatchingInput.equals(NOT_RETRY_INPUT)) {
            throw new IllegalArgumentException("[ERROR]");
        }
        return reMatchingInput.equals(RETRY_INPUT);
    }

    public static <T> T repeat(Supplier<T> supplier) {
        while(true){
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
