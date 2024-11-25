package oncall.exception;

public enum ErrorMessage {
    ERROR_SIGNATURE("[ERROR] "),
    INVALID_INPUT("유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    NOT_FOUND_DAY("요일을 찾을 수 없습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return ERROR_SIGNATURE.message + this.message;
    }
}
