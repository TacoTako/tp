package seedu.address.testutil;

import seedu.address.model.AddressBook;

/**
 * A utility class to help with building Addressbook objects.
 * Example usage: <br>
 *     {@code AddressBook ab = new AddressBookBuilder().withLocation("John", "Doe").build();}
 */
public class AddressBookBuilder {

    private AddressBook addressBook;

    public AddressBookBuilder() {
        addressBook = new AddressBook();
    }

    public AddressBookBuilder(AddressBook addressBook) {
        this.addressBook = addressBook;
    }

    /**
     * Adds a new {@code Location} to the {@code AddressBook} that we are building.
     */
    public AddressBookBuilder withLocation(seedu.address.model.location.Location location) {
        addressBook.addLocation(location);
        return this;
    }

    /**
     * Adds a new note to the {@code AddressBook} that we are building.
     */
    public AddressBookBuilder withNote(seedu.address.model.location.dates.VisitDate date,
            seedu.address.model.location.NoteContent note) {
        addressBook.setNote(date, note);
        return this;
    }

    public AddressBook build() {
        return addressBook;
    }
}
