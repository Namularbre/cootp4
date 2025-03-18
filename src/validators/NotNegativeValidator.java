package validators;

import validators.anotations.NotNegative;

import java.lang.reflect.Field;

public class NotNegativeValidator {
    public static void validate(Object object) throws IllegalAccessException {
        for (Field field : object.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotNegative.class)) {
                if (field.get(object) instanceof Number) {
                    Number value = ((Number) field.get(object)).doubleValue();
                    if (value.doubleValue() < 0.0) {
                        throw new IllegalAccessException(field.getName() + " cannot be negative");
                    }
                } else {
                    throw new IllegalArgumentException(field.getName() + " must be a number");
                }
            }
        }
    }
}
