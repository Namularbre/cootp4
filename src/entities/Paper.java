package entities;

import validators.anotations.NotNegative;
import validators.anotations.NotNull;

public abstract class Paper extends Document {
    @NotNull
    @NotNegative
    protected int nbPages;
    @NotNull
    @NotNegative
    protected double length;
    @NotNull
    @NotNegative
    protected double width;

    public Paper(String type, String periodId, String title, int publicationYear, double value, int nbPages, double length, double width) {
        super(type, periodId, title, publicationYear, value);
        this.nbPages = nbPages;
        this.length = length;
        this.width = width;
    }
}
