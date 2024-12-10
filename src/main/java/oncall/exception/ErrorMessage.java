package oncall.exception;

public enum ErrorMessage {

    ERROR_SIGNATURE("[ERROR] "),
    INVALID_INPUT("유효하지 않은 입력 값입니다. 다시 입력해 주세요."),
    NOT_FOUND_MONTH("존재하지 않는 달 입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return ERROR_SIGNATURE.message + this.message;
    }
}
