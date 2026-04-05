package seedu.address.model;

import javafx.collections.ObservableList;
import seedu.address.model.location.Location;

/**
 * Unmodifiable view of an address book
 */
public interface ReadOnlyAddressBook {

    /**
     * Returns an unmodifiable view of the locations list.
     * This list will not contain any duplicate locations.
     */
    ObservableList<Location> getLocationList();

    /**
     * Returns an unmodifiable map of the scheduled visit dates to their respective global notes.
     */
    java.util.Map<seedu.address.model.location.dates.VisitDate, seedu.address.model.location.NoteContent> getNoteMap();


}
