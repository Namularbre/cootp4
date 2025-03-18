import entities.Document;
import entities.Period;
import exception.NoSelectionException;
import repositories.DocumentRepository;
import repositories.PeriodRepository;
import views.SelectPeriodView;
import views.ShowDocumentDetailsView;
import views.ShowPeriodDetailsView;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Main class of the program
 */
public class Catalog {
    /**
     * Creates the period repository
     * @return A period repository or null is operation fails
     */
    private static PeriodRepository createPeriodRepository() {
        try {
            return PeriodRepository.fromTxtFile();
        } catch (FileNotFoundException | NullPointerException e) {
            System.err.println("Cannot create periods repository: " + e.getMessage());
            System.err.println("File not found or corrupted");
            return null;
        }
    }

    /**
     * Creates the document repository
     * @return A document repository or null is operation fails
     */
    private static DocumentRepository createDocumentRepository() {
        try {
            return DocumentRepository.fromTxtFile();
        } catch (FileNotFoundException | NullPointerException e) {
            System.err.println("Cannot create documents repository: " + e.getMessage());
            System.err.println("File not found or corrupted");
            return null;
        }
    }

    /**
     * Handle the display and business logic of the period selection
     * @param periods a List of Periods
     * @return a selected period or null if none is selected or there is an error
     */
    private static Period doPeriodSelection(List<Period> periods) {
        SelectPeriodView view = new SelectPeriodView(periods);

        try {
            return view.selectPeriod();
        } catch (NoSelectionException e) {
            System.err.println(e.getMessage());
            return null;
        }
    }

    private static Document doPeriodDetails(Period selectedPeriod) {
        ShowPeriodDetailsView showPeriodDetailsView = new ShowPeriodDetailsView(selectedPeriod);
        return showPeriodDetailsView.showPeriodDetails();
    }

    private static void doDocummentDetails(Document selectedDocument) {
        ShowDocumentDetailsView showDocumentDetailsView = new ShowDocumentDetailsView(selectedDocument);
        showDocumentDetailsView.showDocumentDetails();
    }

    public static void main(String[] args) {
        /*
         * Making the repositories
         */
        PeriodRepository periodRepository = createPeriodRepository();
        DocumentRepository documentRepository = createDocumentRepository();

        if (periodRepository == null || documentRepository == null) {
            throw new RuntimeException("Failed building at least one of the repository");
        }

        /*
         * Start of the view part
         */

        Period selectedPeriod = doPeriodSelection(periodRepository.getAllPeriods());

        if (selectedPeriod == null) {
            throw new RuntimeException("No period selected");
        }

        selectedPeriod.setDocuments(documentRepository.fetchDocumentsByPeriod(selectedPeriod));

        Document selectedDocument = doPeriodDetails(selectedPeriod);

        if (selectedDocument == null) {
            throw new RuntimeException("No document selected");
        }

        doDocummentDetails(selectedDocument);
    }
}
