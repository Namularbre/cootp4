package entities;

import validators.anotations.NotNegative;
import validators.anotations.NotNull;

public abstract class Document {
    @NotNull
    protected String type;
    @NotNull
    protected String periodCode;
    @NotNull
    protected String title;
    @NotNull
    @NotNegative
    protected int publicationYear;
    @NotNull
    @NotNegative
    protected double value;

    public Document(String type, String periodId, String title, int publicationYear, double value) {
        this.type = type;
        this.periodCode = periodId;
        this.title = title;
        this.publicationYear = publicationYear;
        this.value = value;
    }

    public double getValue() {
        return value;
    }

    public String getPeriodCode() {
        return periodCode;
    }

    public String getTitle() {
        return title;
    }
}
