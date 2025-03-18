package entities;

public class Video extends Media {
    private final String director;
    private final String comedians;

    public Video(String type, String periodId, String title, int publicationYear, double value, String format, int duration, String director, String comedians) {
        super(type, periodId, title, publicationYear, value, format, duration);
        this.director = director;
        this.comedians = comedians;
    }

    @Override
    public String toString() {
        return "Type: Vidéo\n" +
                "Titre: " + this.title + "\n" +
                "Date de publication: " + this.publicationYear + "\n" +
                "Format: " + this.format + "\n" +
                "Durée: " + this.duration + "s \n" +
                "Directeur: " + this.director + "\n" +
                "Comédiens: " + this.comedians + "\n" +
                "Type: " + this.type + "\n" +
                "Valeur: " + this.value + "€\n";
    }
}
