package entities;

import validators.anotations.NotNull;

import java.util.List;

public class Period {
    @NotNull
    private final String code;
    @NotNull
    private final String label;
    private List<Document> documents;

    public Period(String code, String label) {
        this.code = code;
        this.label = label;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }

    public String getCode() {
        return code;
    }

    public String getLabel() {
        return label;
    }

    @Override
    public String toString() {
        return code + " - " + label;
    }
}
