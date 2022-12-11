package pairmatching.constant;

public enum Function {
    MATCHING("1"),
    INQUIRY("2"),
    INITIALIZE("3"),
    QUIT("Q"),
    ;

    private String format;

    Function(String format) {
        this.format = format;
    }
}
