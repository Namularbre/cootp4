package entities;

import validators.anotations.NotNegative;
import validators.anotations.NotNull;

public class Magazine extends Paper {
    @NotNull
    @NotNegative
    private final int number;
    private final String theme;

    public Magazine(String type, String periodId, String title, int publicationYear, double value, int nbPages, double length, double width, int number, String theme) {
        super(type, periodId, title, publicationYear, value, nbPages, length, width);
        this.number = number;
        this.theme = theme;
    }

    @Override
    public String toString() {
        return  "Type: Magasine\n"
                + "Numéro: " + this.number + "\n"
                + "Thème: " + this.theme + "\n"
                + "Nombre de pages: " + this.nbPages + "\n"
                + "Longueur: " + this.length + " cm\n"
                + "Largeur: " + this.width + " cm\n"
                + "Type: " + this.type + "\n"
                + "Code période: " + this.periodCode + "\n"
                + "Titre: " + this.title + "\n"
                + "Année de publication: " + this.publicationYear + "\n"
                + "Valeur: " + this.value + "€\n";
    }
}
