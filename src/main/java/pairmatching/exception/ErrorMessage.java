package pairmatching.exception;

public enum ErrorMessage {
    WRONG_FILE_PATH("파일의 경로에 해당 파일이 없습니다. 관리자에게 문의하세요."),
    WRONG_PAIR("페어는 2~3명 이어야 합니다.");

    ErrorMessage(String message) {
        this.message = message;
    }

    private static final String PREFIX = "[ERROR] ";

    private String message;

    public String getMessage() {
        return PREFIX + message;
    }
}
