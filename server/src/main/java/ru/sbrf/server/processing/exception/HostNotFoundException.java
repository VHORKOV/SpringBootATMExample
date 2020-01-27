package ru.sbrf.server.processing.exception;

public class HostNotFoundException extends RuntimeException {
    public HostNotFoundException() {
    }

    public HostNotFoundException(String message) {
        super(message);
    }

    public HostNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public HostNotFoundException(Throwable cause) {
        super(cause);
    }

    public HostNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
