package seedu.address.logic.parser.exceptions;

/**
 * Represents an error which occurs during parsing of an empty field.
 */
public class EmptyFieldException extends ParseException {
    public EmptyFieldException() {
        super("");
    }
}
