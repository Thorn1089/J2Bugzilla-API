package com.j2bugzilla.api;

import java.util.Set;


/**
 * The {@code AttachmentRepository} allows for existing {@link Attachment} objects to be retrieved and new
 * attachments to be associated with {@link Bug bugs}.
 * 
 * @author Tom
 */
public interface AttachmentRepository {

	/**
	 * Posts the given {@link Attachment} to the specified{@link Bug bug}. 
	 * @param attachment An {@code Attachment} to upload to the Bugzilla installation.
	 * @param bug A {@code Bug} to associate the attachment with.
	 * @return An {@code int} identifying the new attachment.
	 */
	int attachTo(Attachment attachment, Bug bug);
	
	/**
	 * Retrieves an {@link Attachment} based on the given ID, or throws an exception if no matching attachment exists.
	 * @param id A {@code int} identifying a particular attachment.
	 * @return An {@code Attachment} object.
	 */
	Attachment get(int id);
	
	/**
	 * Retrieves all {@link Attachment} objects specified as a {@code Set}. If nonexistent IDs are included,
	 * they are ignored.
	 * @param ids A set of {@code ints} identifying attachments.
	 * @return A {@code Set} of retrieved {@code Attachments}.
	 */
	Set<Attachment> getAll(int... ids);
	
}
