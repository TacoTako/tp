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

public class UndoCommandTest {

    @Test
    public void execute_canUndo_success() {
        Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs(), new ShortcutMap());
        model.saveState();
        model.setAddressBook(new AddressBook());
        model.commitState();

        Model expectedModel = new ModelManager(getTypicalAddressBook(), new UserPrefs(), new ShortcutMap());
        assertCommandSuccess(new UndoCommand(), model, UndoCommand.MESSAGE_SUCCESS, expectedModel);
    }

    @Test
    public void execute_cannotUndo_failure() {
        Model model = new ModelManager();
        assertCommandFailure(new UndoCommand(), model, UndoCommand.MESSAGE_FAILURE);
    }
}
