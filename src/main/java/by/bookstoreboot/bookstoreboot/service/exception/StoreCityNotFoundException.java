package by.bookstoreboot.bookstoreboot.service.exception;

public class StoreCityNotFoundException extends RuntimeException {
    public StoreCityNotFoundException() {
    }

    public StoreCityNotFoundException(String message) {
        super(message);
    }

    public StoreCityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StoreCityNotFoundException(Throwable cause) {
        super(cause);
    }

    public StoreCityNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
