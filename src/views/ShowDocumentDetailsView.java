package views;

import entities.Document;

import javax.swing.*;

public class ShowDocumentDetailsView {
    private final Document document;

    public ShowDocumentDetailsView(Document document) {
        this.document = document;
    }

    public void showDocumentDetails() {
        String title = "Information pour " +
                this.document.getTitle() +
                "\n";

        String details = "Détails: " +
                this.document +
                "\n";

        JOptionPane.showMessageDialog(
                null,
                details,
                title,
                JOptionPane.INFORMATION_MESSAGE
        );
    }
}
