package exception;

/**
 * This exception must be thrown when a line containing a book is malformed
 */
public class BookMalformedException extends RuntimeException {
    public BookMalformedException(String message) {
        super("Book malformed: " + message);
    }
}
