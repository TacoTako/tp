package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.DESC_AMY;
import static seedu.address.logic.commands.CommandTestUtil.DESC_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DATE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import org.junit.jupiter.api.Test;

import seedu.address.logic.commands.EditCommand.EditLocationDescriptor;
import seedu.address.testutil.EditLocationDescriptorBuilder;

public class EditLocationDescriptorTest {

    @Test
    public void equals() {
        EditLocationDescriptor descriptorWithSameValues = new EditLocationDescriptor(DESC_AMY);
        assertTrue(DESC_AMY.equals(descriptorWithSameValues));

        assertTrue(DESC_AMY.equals(DESC_AMY));
        assertFalse(DESC_AMY.equals(null));
        assertFalse(DESC_AMY.equals(5));
        assertFalse(DESC_AMY.equals(DESC_BOB));

        EditLocationDescriptor editedAmy = new EditLocationDescriptorBuilder(DESC_AMY)
                .withName(VALID_NAME_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        editedAmy = new EditLocationDescriptorBuilder(DESC_AMY)
                .withPhone(VALID_PHONE_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        editedAmy = new EditLocationDescriptorBuilder(DESC_AMY)
                .withEmail(VALID_EMAIL_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        editedAmy = new EditLocationDescriptorBuilder(DESC_AMY)
                .withAddress(VALID_ADDRESS_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        // IMPORTANT: use visitDates (not visitDate)
        editedAmy = new EditLocationDescriptorBuilder(DESC_AMY)
                .withVisitDates(VALID_DATE_BOB).build();
        assertFalse(DESC_AMY.equals(editedAmy));

        editedAmy = new EditLocationDescriptorBuilder(DESC_AMY)
                .withTags(VALID_TAG_HUSBAND).build();
        assertFalse(DESC_AMY.equals(editedAmy));
    }

    @Test
    public void toStringMethod() {
        EditLocationDescriptor editLocationDescriptor = new EditLocationDescriptor();

        String expected = EditLocationDescriptor.class.getCanonicalName()
                + "{name=" + editLocationDescriptor.getName().orElse(null)
                + ", phone=" + editLocationDescriptor.getPhone().orElse(null)
                + ", email=" + editLocationDescriptor.getEmail().orElse(null)
                + ", address=" + editLocationDescriptor.getAddress().orElse(null)
                + ", postalCode=" + editLocationDescriptor.getPostalCode().orElse(null)
                + ", visitDates=" + editLocationDescriptor.getVisitDates().orElse(null)
                + ", visitDatesToAdd=" + editLocationDescriptor.getVisitDatesToAdd().orElse(null)
                + ", visitDatesToRemove=" + editLocationDescriptor.getVisitDatesToRemove().orElse(null)
                + ", tags=" + editLocationDescriptor.getTags().orElse(null)
                + ", tagsToAdd=" + editLocationDescriptor.getTagsToAdd().orElse(null)
                + ", tagsToRemove=" + editLocationDescriptor.getTagsToRemove().orElse(null)
                + "}";

        assertEquals(expected, editLocationDescriptor.toString());
    }
}
