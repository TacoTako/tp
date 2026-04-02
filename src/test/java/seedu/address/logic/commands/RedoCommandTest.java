package seedu.address.logic.commands;

import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalLocations.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.ShortcutMap;
import seedu.address.model.UserPrefs;

public class RedoCommandTest {

    @Test
    public void execute_canRedo_success() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs(), new ShortcutMap());
        model.saveState();
        model.setAddressBook(new AddressBook());
        model.commitState();
        model.undoState();

        Model expectedModel = new ModelManager(new AddressBook(), new UserPrefs(), new ShortcutMap());
        assertCommandSuccess(new RedoCommand(), model, RedoCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_cannotRedo_failure() {
        Model model = new ModelManager();
        assertCommandFailure(new RedoCommand(), model, RedoCommand.MESSAGE_FAILURE);
    }
}
