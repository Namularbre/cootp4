package utils;

import entities.*;
import exception.*;

/**
 * <i>(Factory pattern for Document)</i>
 * <br>
 * This class helps create document from line of the file
 */
public class DocumentFactory {
    // Document type code constants
    public static final String BOOK_TYPE = "L";
    public static final String MAGAZINE_TYPE = "M";
    public static final String VIDEO_TYPE = "V";
    public static final String AUDIO_TYPE = "A";

    // Line number constants
    private static final int N_LINE_CODE = 0;
    private static final int N_LINE_PERIOD = 1;
    private static final int N_LINE_TITLE = 2;
    private static final int N_LINE_PUBLICATION_YEAR = 3;
    private static final int N_LINE_VALUE = 4;
    private static final int N_LINE_NB_PAGES = 5;
    private static final int N_LINE_WIDTH = 6;
    private static final int N_LINE_LENGTH = 7;
    private static final int N_LINE_FORMAT = 5;
    private static final int N_LINE_DURATION = 6;

    /**
     * create a document from the type code and a line of the file split on every ';'
     * @throws AudioMalformedException if there are missing fields for an audio
     * @throws BookMalformedException if there are missing fields for a Book
     * @throws MagazineMalformedException if there are missing fields for a magazine
     * @throws VideoMalformedException if there are missing fields for a video
     * @throws UnknownDocumentType if the document type code is unknown
     * @param type the type code of the document
     * @param splitedLine a line of the file split on every ';'
     * @return a document of type Audio, Book, Magazine or Video
     */
    public static Document createDocument(String type, String[] splitedLine) {
        return switch (type) {
            case BOOK_TYPE -> createBook(splitedLine);
            case MAGAZINE_TYPE -> createMagazine(splitedLine);
            case VIDEO_TYPE -> createVideo(splitedLine);
            case AUDIO_TYPE -> createAudio(splitedLine);
            default -> throw new UnknownDocumentType(type);
        };
    }

    /**
     * creates a book from a line of a file
     * @param splitedLine a line of the file split on every ';'
     * @throws BookMalformedException if there are missing fields for the book
     * @return A document of book type
     */
    private static Document createBook(String[] splitedLine) {
        final int nLineAuthor     = 8;
        final int nLineCollection = 9;

        String code;
        String period;
        String title;
        int publicationYear;
        double value;
        int nbPages;
        double length;
        double width;
        String author;
        String collection;

        try {
            code = splitedLine[N_LINE_CODE];
            period = splitedLine[N_LINE_PERIOD];
            title = splitedLine[N_LINE_TITLE];
            publicationYear = Integer.parseInt(splitedLine[N_LINE_PUBLICATION_YEAR]);
            value = Double.parseDouble(splitedLine[N_LINE_VALUE]);
            nbPages = Integer.parseInt(splitedLine[N_LINE_NB_PAGES]);
            length = Double.parseDouble(splitedLine[N_LINE_LENGTH]);
            width = Double.parseDouble(splitedLine[N_LINE_WIDTH]);
        } catch (NumberFormatException | NullPointerException | IndexOutOfBoundsException e) {
            throw new BookMalformedException(e.getMessage());
        }

        // Nullable fields
        try {
            author = splitedLine[nLineAuthor];
        } catch (IndexOutOfBoundsException e) {
            author = "";
        }

        try {
            collection = splitedLine[nLineCollection];
        } catch (IndexOutOfBoundsException e) {
            collection = "";
        }

        return new Book(code, period, title, publicationYear, value, nbPages, length, width, author, collection);
    }

    /**
     * create a magazine from a line of the file
     * @param splitedLine a line of the file split on every ';'
     * @throws MagazineMalformedException if there are missing field for magazine
     * @return a document of magazine type
     */
    private static Document createMagazine(String[] splitedLine) {
        final int nLineNumber     = 8;
        final int nLineTheme      = 9;

        String code;
        String period;
        String title;
        int publicationYear;
        double width;
        int nbPages;
        double length;
        double value;
        int number;
        String theme;

        try {
            code = splitedLine[N_LINE_CODE];
            period = splitedLine[N_LINE_PERIOD];
            title = splitedLine[N_LINE_TITLE];
            publicationYear = Integer.parseInt(splitedLine[N_LINE_PUBLICATION_YEAR]);
            width = Double.parseDouble(splitedLine[N_LINE_WIDTH]);
            nbPages = Integer.parseInt(splitedLine[N_LINE_NB_PAGES]);
            length = Double.parseDouble(splitedLine[N_LINE_LENGTH]);
            value = Double.parseDouble(splitedLine[N_LINE_VALUE]);
            number = Integer.parseInt(splitedLine[nLineNumber]);
        } catch (NumberFormatException | NullPointerException | IndexOutOfBoundsException e) {
            throw new MagazineMalformedException(e.getMessage());
        }

        // nullable field
        try {
            theme = splitedLine[nLineTheme];
        } catch (IndexOutOfBoundsException e) {
            theme = "";
        }

        return new Magazine(code, period, title, publicationYear, width, nbPages, length, value, number, theme);
    }

    /**
     * create a video from a line of the file
     * @throws VideoMalformedException if there are missing fields to create a video
     * @param splitedLine a line of the file split on every ';'
     * @return a document of type Video
     */
    private static Document createVideo(String[] splitedLine) {
        final int nLineDirector  = 7;
        final int nLineComedians = 8;

        String code;
        String period;
        String title;
        int publicationYear;
        double value;
        String format;
        int duration;
        String director;
        String comedians;

        try {
            code = splitedLine[N_LINE_CODE];
            period = splitedLine[N_LINE_PERIOD];
            title = splitedLine[N_LINE_TITLE];
            publicationYear = Integer.parseInt(splitedLine[N_LINE_PUBLICATION_YEAR]);
            value = Double.parseDouble(splitedLine[N_LINE_VALUE]);
            format = splitedLine[N_LINE_FORMAT];
            duration = Integer.parseInt(splitedLine[N_LINE_DURATION]);
        } catch (NumberFormatException | NullPointerException | IndexOutOfBoundsException e) {
            throw new VideoMalformedException(e.getMessage());
        }

        // nullable fields
        try {
            director = splitedLine[nLineDirector];
        } catch (IndexOutOfBoundsException e) {
            director = "";
        }

        try {
            comedians = splitedLine[nLineComedians];
        } catch (IndexOutOfBoundsException e) {
            comedians = "";
        }

        return new Video(code, period, title, publicationYear, value, format, duration, director, comedians);
    }

    /**
     * create a Audio document from the line of a file
     * @throws AudioMalformedException if there are missing fields to create an audio
     * @param splitedLine a line of the file split on every ';'
     * @return a document of type Audio
     */
    private static Document createAudio(String[] splitedLine) {
        final int nLineAuthor      = 7;
        final int nLineInterpreter = 8;

        String code;
        String period;
        String title;
        int publicationYear;
        double value;
        String format;
        int duration;
        String author;
        String interpreter;

        try {
            code = splitedLine[N_LINE_CODE];
            period = splitedLine[N_LINE_PERIOD];
            title = splitedLine[N_LINE_TITLE];
            publicationYear = Integer.parseInt(splitedLine[N_LINE_PUBLICATION_YEAR]);
            value = Double.parseDouble(splitedLine[N_LINE_VALUE]);
            format = splitedLine[N_LINE_FORMAT];
            duration = Integer.parseInt(splitedLine[N_LINE_DURATION]);
        } catch (NumberFormatException | NullPointerException | IndexOutOfBoundsException e) {
            throw new AudioMalformedException(e.getMessage());
        }

        // nullable
        try {
            author = splitedLine[nLineAuthor];
        } catch (IndexOutOfBoundsException e) {
            author = "";
        }

        try {
            interpreter = splitedLine[nLineInterpreter];
        } catch (IndexOutOfBoundsException e) {
            interpreter = "";
        }

        return new Audio(code, period, title, publicationYear, value, format, duration, author, interpreter);
    }
}
