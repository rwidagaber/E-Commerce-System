package exception;

import enums.ErrorCode;

public class AppExceptionHandler extends RuntimeException {

  private final ErrorCode errorCode;
    public AppExceptionHandler(String message, ErrorCode errorCode) {
        super(message);
        this.errorCode = errorCode;
    }
    public ErrorCode getErrorCode() {
        return errorCode;
    }
}

// exception/AppException.java

