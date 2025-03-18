package repositories;

import entities.Period;
import utils.LineFileReader;
import validators.Validator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class PeriodRepository {
    public static final String SEPARATOR = ";";

    private static final String txtFilePath = "epoques.txt";
    private final List<Period> periods;

    public PeriodRepository(List<Period> periods) {
        this.periods = periods;
    }

    /**
     * Generate a period repository from string can return null if operation fails.
     * @return a period repository or null if operation fails
     */
    public static PeriodRepository fromTxtFile() throws FileNotFoundException {
        List<String> content = LineFileReader.ReadAllByLines(txtFilePath);

        List<Period> periods = new ArrayList<>();

        // line to Period
        for (String line : content) {
            String[] parts = line.split(SEPARATOR);

            if (parts.length != 2) {
                System.err.println("Invalid period line: " + line);
                continue;
            }

            String periodCode = parts[0];
            String periodName = parts[1];

            Period period = new Period(periodCode, periodName);

            if (Validator.isValid(period)) {
                periods.add(period);
            }
        }

        return new PeriodRepository(periods);
    }

    public List<Period> getAllPeriods() {
        return this.periods;
    }
}
