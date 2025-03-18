package exception;

public class VideoMalformedException extends RuntimeException {
    public VideoMalformedException(String message) {
        super("Video malformed: " + message);
    }
}
