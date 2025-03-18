package entities;

public class Book extends Paper {
    private final String author;
    private final String collection;

    public Book(String type, String periodId, String title, int publicationYear, double value, int nbPages, double length, double width, String author, String collection) {
        super(type, periodId, title, publicationYear, value, nbPages, length, width);
        this.author = author;
        this.collection = collection;
    }

    @Override
    public String toString() {
        return  "Type: Livre\n"
                + "Titre: " + this.title + "\n"
                + "Auteur: " + this.author + "\n"
                + "Collection: " + this.collection + "\n"
                + "Nombre de pages: " + this.nbPages + "\n"
                + "Longueur: " + this.length + " cm\n"
                + "Largeur: " + this.width + " cm\n"
                + "Type: " + this.type + "\n"
                + "Code période: " + this.periodCode + "\n"
                + "Année de publication: " + this.publicationYear + "\n"
                + "Valeur: " + this.value + "€\n";
    }
}
