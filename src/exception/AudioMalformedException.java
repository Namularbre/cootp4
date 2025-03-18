package exception;

public class AudioMalformedException extends RuntimeException {
    public AudioMalformedException(String message) {
        super("Audio malformed: " + message);
    }
}
