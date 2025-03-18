package entities;

public class Audio extends Media {
    private final String author;
    private final String interpreter;

    public Audio(String type, String periodId, String title, int publicationYear, double value, String format, int duration, String author, String interpreter) {
        super(type, periodId, title, publicationYear, value, format, duration);
        this.author = author;
        this.interpreter = interpreter;
    }

    @Override
    public String toString() {
        return  "Type: Audio\n"
                + "Titre: " + this.title + "\n"
                + "Auteur: " + this.author + "\n"
                + "Date de publication: " + this.publicationYear + "\n"
                + "Durée: " + this.duration + "s\n"
                + "Format: " + this.format + "s\n"
                + "Type: " + this.type + "\n"
                + "Code période: " + this.periodCode + "\n"
                + "Valeur: " + this.value + "€\n"
                + "Interprète: " + this.interpreter + "\n";
    }
}
