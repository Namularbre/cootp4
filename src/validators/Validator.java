package validators;

import entities.Audio;
import entities.Video;

/**
 * The Validator class validate an entity using other validators (and some spaghetti code)
 */
public class Validator {
    public static boolean isValid(Object object) {
        try {
            NotNullValidator.validate(object);
            NotNegativeValidator.validate(object);

            if (object instanceof Video) {
                Video video = (Video) object;
                if (!video.getFormat().equalsIgnoreCase("DVD") && !video.getFormat().equalsIgnoreCase("BLU-RAY")) {
                    throw new IllegalArgumentException("Field " + object.getClass().getName() + " is not a valid video format");
                }
            }

            if (object instanceof Audio) {
                Audio audio = (Audio) object;
                if (!audio.getFormat().equalsIgnoreCase("CD") && !audio.getFormat().equalsIgnoreCase("MP3")) {
                    throw new IllegalArgumentException("Field " + object.getClass().getName() + " is not a valid audio format");
                }
            }

            return true;
        } catch (IllegalAccessException e) {
            System.err.println("Cannot access a field: " + e.getMessage());
            return false;
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return false;
        }
    }
}
