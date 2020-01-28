package ru.sbrf.client.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
public class ATMInternalErrorException extends RuntimeException {
    public ATMInternalErrorException() {
    }

    public ATMInternalErrorException(String message) {
        super(message);
    }

    public ATMInternalErrorException(String message, Throwable cause) {
        super(message, cause);
    }

    public ATMInternalErrorException(Throwable cause) {
        super(cause);
    }

    public ATMInternalErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
