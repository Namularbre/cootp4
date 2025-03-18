package validators;

import validators.anotations.NotNull;

import java.lang.reflect.Field;

public class NotNullValidator {
    public static void validate(Object object) throws IllegalAccessException {
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotNull.class)) {
                if (field.get(object) == null || field.get(object).toString().trim().isEmpty()) {
                    throw new IllegalArgumentException("Field " + field.getName() + " is required");
                }
            }
        }
    }
}
