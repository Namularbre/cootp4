package views;

import java.util.List;

import entities.Period;
import exception.NoSelectionException;

import javax.swing.*;

public class SelectPeriodView {
    private final List<Period> content;

    public SelectPeriodView(List<Period> content) {
        this.content = content;
    }

    public Period selectPeriod() {
        // gather all period labels in one array
        String[] stringPeriods = content.stream()
                .map(Period::toString)
                .toArray(String[]::new);

        if (stringPeriods.length == 0) {
            JOptionPane.showMessageDialog(null, "There is no period");
            return null;
        }

        String selectedStringPeriod = (String) JOptionPane.showInputDialog(
                null,
                "Sélectionnez une période",
                "Liste des époques",
                JOptionPane.QUESTION_MESSAGE,
                null,
                stringPeriods,
                stringPeriods[0]
        );

        if (selectedStringPeriod != null) {
            return content.stream()
                    .filter(period -> period.getCode().equals(selectedStringPeriod.split(" ")[0]))
                    .findFirst()
                    .orElse(null);
        }

        throw new NoSelectionException();
    }
}
