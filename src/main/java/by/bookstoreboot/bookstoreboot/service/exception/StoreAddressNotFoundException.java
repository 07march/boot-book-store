package by.bookstoreboot.bookstoreboot.service.exception;

public class StoreAddressNotFoundException extends RuntimeException {
    public StoreAddressNotFoundException() {
    }

    public StoreAddressNotFoundException(String message) {
        super(message);
    }

    public StoreAddressNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StoreAddressNotFoundException(Throwable cause) {
        super(cause);
    }

    public StoreAddressNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
