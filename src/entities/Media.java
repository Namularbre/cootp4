package entities;

import validators.anotations.NotNegative;
import validators.anotations.NotNull;

public abstract class Media extends Document {
    @NotNull
    protected String format;
    @NotNull
    @NotNegative
    protected int duration;

    public Media(String type, String periodId, String title, int publicationYear, double value, String format, int duration) {
        super(type, periodId, title, publicationYear, value);
        this.format = format;
        this.duration = duration;
    }

    public String getFormat() {
        return format;
    }
}
