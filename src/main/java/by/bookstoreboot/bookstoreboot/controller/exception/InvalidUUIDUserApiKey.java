package by.bookstoreboot.bookstoreboot.controller.exception;

public class InvalidUUIDUserApiKey extends RuntimeException {
    public InvalidUUIDUserApiKey() {
    }

    public InvalidUUIDUserApiKey(String message) {
        super(message);
    }

    public InvalidUUIDUserApiKey(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidUUIDUserApiKey(Throwable cause) {
        super(cause);
    }

    public InvalidUUIDUserApiKey(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
