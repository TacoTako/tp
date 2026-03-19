package seedu.address.testutil;

import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import seedu.address.logic.commands.EditCommand.EditLocationDescriptor;
import seedu.address.model.location.Address;
import seedu.address.model.location.Email;
import seedu.address.model.location.Location;
import seedu.address.model.location.Name;
import seedu.address.model.location.Phone;
import seedu.address.model.location.PostalCode;
import seedu.address.model.location.VisitDate;
import seedu.address.model.tag.Tag;

/**
 * A utility class to help with building EditLocationDescriptor objects.
 */
public class EditLocationDescriptorBuilder {

    private EditLocationDescriptor descriptor;

    public EditLocationDescriptorBuilder() {
        descriptor = new EditLocationDescriptor();
    }

    public EditLocationDescriptorBuilder(EditLocationDescriptor descriptor) {
        this.descriptor = new EditLocationDescriptor(descriptor);
    }

    /**
     * Returns an {@code EditLocationDescriptor} with fields containing {@code location}'s details
     */
    public EditLocationDescriptorBuilder(Location location) {
        descriptor = new EditLocationDescriptor();
        descriptor.setName(location.getName());
        location.getPhone().ifPresent(descriptor::setPhone);
        location.getEmail().ifPresent(descriptor::setEmail);
        location.getAddress().ifPresent(descriptor::setAddress);
        location.getPostalCode().ifPresent(descriptor::setPostalCode);
        descriptor.setVisitDates(location.getVisitDates());
        descriptor.setTags(location.getTags());
    }

    public EditLocationDescriptorBuilder withName(String name) {
        descriptor.setName(new Name(name));
        return this;
    }

    public EditLocationDescriptorBuilder withPhone(String phone) {
        descriptor.setPhone(new Phone(phone));
        return this;
    }

    public EditLocationDescriptorBuilder withEmail(String email) {
        descriptor.setEmail(new Email(email));
        return this;
    }

    public EditLocationDescriptorBuilder withAddress(String address) {
        descriptor.setAddress(new Address(address));
        return this;
    }

    public EditLocationDescriptorBuilder withPostalCode(String postalCode) {
        descriptor.setPostalCode(new PostalCode(postalCode));
        return this;
    }

    /**
     * Sets visit dates (override)
     */
    public EditLocationDescriptorBuilder withVisitDates(String... visitDates) {
        Set<VisitDate> visitDateSet =
                Stream.of(visitDates).map(VisitDate::new).collect(Collectors.toSet());
        descriptor.setVisitDates(visitDateSet);
        return this;
    }

    /**
     * Convenience method (keep for compatibility)
     */
    public EditLocationDescriptorBuilder withVisitDate(String visitDate) {
        return withVisitDates(visitDate);
    }

    public EditLocationDescriptorBuilder withTags(String... tags) {
        Set<Tag> tagSet =
                Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTags(tagSet);
        return this;
    }

    public EditLocationDescriptorBuilder withVisitDatesToAdd(String... visitDates) {
        Set<VisitDate> visitDateSet =
                Stream.of(visitDates).map(VisitDate::new).collect(Collectors.toSet());
        descriptor.setVisitDatesToAdd(visitDateSet);
        return this;
    }

    public EditLocationDescriptorBuilder withVisitDatesToRemove(String... visitDates) {
        Set<VisitDate> visitDateSet =
                Stream.of(visitDates).map(VisitDate::new).collect(Collectors.toSet());
        descriptor.setVisitDatesToRemove(visitDateSet);
        return this;
    }

    public EditLocationDescriptorBuilder withTagsToAdd(String... tags) {
        Set<Tag> tagSet =
                Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTagsToAdd(tagSet);
        return this;
    }

    public EditLocationDescriptorBuilder withTagsToRemove(String... tags) {
        Set<Tag> tagSet =
                Stream.of(tags).map(Tag::new).collect(Collectors.toSet());
        descriptor.setTagsToRemove(tagSet);
        return this;
    }

    public EditLocationDescriptor build() {
        return descriptor;
    }
}
