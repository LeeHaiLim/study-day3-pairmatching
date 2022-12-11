package pairmatching.view;

import pairmatching.dto.MatchResultDto;

public class OutputView {
    private static final String ERROR_PREFIX = "[ERROR] ";

    public static void printErrorMessage(String message) {
        System.out.println(ERROR_PREFIX + message);
    }

    public static void printMatchResult(MatchResultDto matchResultDto) {
        System.out.println("페어 매칭 결과입니다.");
        matchResultDto.getMatchResult().stream().forEach(System.out::println);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }
}
