package com.j2bugzilla.api;

import java.util.Set;

import com.google.common.base.Optional;

/**
 * The {@code AttachmentRepository} allows for existing {@link Attachment} objects to be retrieved and new
 * attachments to be associated with {@link Bug bugs}.
 * 
 * @author Tom
 */
public interface AttachmentRepository {

	/**
	 * Posts the given {@link Attachment} to the specified set of {@link Bug bugs}. If nonexistent bugs are
	 * specified, they will be ignored.
	 * @param attachment An {@code Attachment} to upload to the Bugzilla installation.
	 * @param bugs A {@code Bug} to associate the attachment with.
	 */
	void attachTo(Attachment attachment, Bug bug);
	
	/**
	 * Retrieves an {@link Attachment} based on the given ID, or an absent {@link Optional} if the ID does not
	 * exist in the remote Bugzilla installation.
	 * @param id A {@code int} identifying a particular attachment.
	 * @return An {@code Optional<Attachment>} object.
	 */
	Optional<Attachment> get(int id);
	
	/**
	 * Retrieves all {@link Attachment} objects specified as a {@code Set}. If nonexistent IDs are included,
	 * they are ignored.
	 * @param ids A set of {@code ints} identifying attachments.
	 * @return A {@code Set} of retrieved {@code Attachments}.
	 */
	Set<Attachment> getAll(int... ids);
	
}
