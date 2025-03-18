package views;

import entities.Document;
import entities.Period;
import exception.NoSelectionException;

import javax.swing.*;

public class ShowPeriodDetailsView {
    private final Period period;

    public ShowPeriodDetailsView(Period period) {
        this.period = period;
    }

    private double calculateDocumentsTotalValue() {
        double value = 0.0;

        for (Document d : period.getDocuments()) {
            value += d.getValue();
        }

        return value;
    }

    public Document showPeriodDetails() {
        // create display
        StringBuilder message = new StringBuilder();
        message.append("Informations sur l'époque: ").append(period.getLabel()).append("\n");
        message.append("Nombre de documents: ").append(this.period.getDocuments().size()).append("\n");
        message.append("Valeur total de la période: ").append(this.calculateDocumentsTotalValue()).append("€\n");

        // Gather all document names in an array (it's like a cheap C# linq, didn't know that Java as that, it's great !)
        String[] documentNames = this.period.getDocuments().stream()
                .map(Document::getTitle)
                .toArray(String[]::new);

        if (!this.period.getDocuments().isEmpty()) {
            String selectedDocumentName = (String) JOptionPane.showInputDialog(
                    null,
                    message.append("Sélectionnez un document").toString(),
                    "Documents de l'époque " + period.getLabel(),
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    documentNames,
                    null
            );

            if (selectedDocumentName != null) {
                return this.period.getDocuments().stream()
                        .filter(doc -> doc.getTitle().equals(selectedDocumentName))
                        .findFirst()
                        .orElse(null);
            }

            throw new NoSelectionException();
        } else {
            JOptionPane.showMessageDialog(
                    null,
                    message.toString(),
                    "Documents de l'époque " + period.getLabel(),
                    JOptionPane.INFORMATION_MESSAGE
            );

            return null;
        }
    }
}
