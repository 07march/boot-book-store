package by.bookstoreboot.bookstoreboot.service.exception;

public class AuthorInBookNotFoundException extends RuntimeException {
    public AuthorInBookNotFoundException() {
    }

    public AuthorInBookNotFoundException(String message) {
        super(message);
    }

    public AuthorInBookNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public AuthorInBookNotFoundException(Throwable cause) {
        super(cause);
    }

    public AuthorInBookNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
