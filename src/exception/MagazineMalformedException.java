package exception;

public class MagazineMalformedException extends RuntimeException {
    public MagazineMalformedException(String message) {
        super("Magazine malformed: " + message);
    }
}
