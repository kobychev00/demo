package exeptions;

public class BadPersonNumberException extends RuntimeException {
    public BadPersonNumberException(String message) {
        super(message);
    }
}
