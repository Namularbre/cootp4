package repositories;

import entities.Document;
import entities.Period;
import exception.*;
import utils.DocumentFactory;
import utils.LineFileReader;
import validators.Validator;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DocumentRepository {
    public static final String FILE_PATH = "documents.txt";

    private final List<Document> documents;

    public DocumentRepository(List<Document> documents) {
        this.documents = documents;
    }

    /**
     * Creates a DocumentRepository from document.txt
     * @throws exception.AudioMalformedException if audio entry is malformed
     * @throws exception.BookMalformedException if book entry is malformed
     * @throws exception.MagazineMalformedException if magazine entry is malformed
     * @throws exception.VideoMalformedException if video entry is malformed
     * @return A DocumentRepository or <strong>null</strong> if the file cannot be read.
     */
    public static DocumentRepository fromTxtFile() throws FileNotFoundException {
        List<String> lines = LineFileReader.ReadAllByLines(FILE_PATH);

        List<Document> documents = new ArrayList<>();

        for (String line : lines) {
            String[] splitLine = line.split(";");

            if (splitLine.length < 2) {
                System.err.println("Malformed line: " + line);
                continue;
            }

            try {
                String docType = splitLine[0];
                Document document = DocumentFactory.createDocument(docType, splitLine);

                if (Validator.isValid(document)) {
                    documents.add(document);
                }
            } catch (AudioMalformedException | BookMalformedException | MagazineMalformedException |
                     VideoMalformedException e) {

                System.err.println("Malformed line : " + line);
                System.err.println(e.getMessage());
            } catch (UnknownDocumentType e) {
                System.err.println("skipping this one: " + e.getMessage());
            }
        }

        return new DocumentRepository(documents);
    }

    /**
     * fetch all documents present in a specific period
     * @param period a non-null Period
     * @return A list of document with the same period code/id
     */
    public List<Document> fetchDocumentsByPeriod(Period period) {
        return this.documents
                .stream()
                .filter(document -> Objects.equals(document.getPeriodCode(), period.getCode()))
                .collect(Collectors.toList());
    }
}
