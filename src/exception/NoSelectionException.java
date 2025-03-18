package exception;

public class NoSelectionException extends RuntimeException {
    public NoSelectionException() {
        super("No selection");
    }
}
