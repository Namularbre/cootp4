package exception;

public class UnknownDocumentType extends RuntimeException {
    public UnknownDocumentType(String type) {
        super("Unknown document type: " + type);
    }
}
