package exception;

public class UnknowDocumentTitleException extends RuntimeException {
    public UnknowDocumentTitleException(String title) {
        super("Unknown title: " + title);
    }
}
