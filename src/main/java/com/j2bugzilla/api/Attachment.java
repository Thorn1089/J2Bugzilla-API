package com.j2bugzilla.api;

import java.time.Instant;
import java.util.Optional;


/**
 * The {@code Attachment} class represents a file which is associated with one or more
 * {@link Bug} reports.
 * 
 * @author Tom
 */
public interface Attachment {
	
	/**
	 * @return An {@link  Optional} {@code Integer} identifying this attachment. Absent if the attachment has not been persisted with a remote
	 * Bugzilla installation.
	 */
	Optional<Integer> getAttachmentId();
	
	/**
	 * @return An {@link Optional} {@code Integer} identifying the {@link Bug} this attachment is associated with. Absent if the attachment has not
	 * been persisted with a remote Bugzilla installation.
	 */
	Optional<Integer> getBugId();
	
	/**
	 * @return A {@code String} naming this {@link Attachment}.
	 */
	String getName();
	
	/**
	 * @return An array of {@code byte} data that this {@link Attachment} represents. Changes to the array are not written through to the attachment.
	 */
	byte[] getData();
	
	Optional<Instant> getCreationDate();
	
	Optional<Instant> getModificationDate();
	
	/**
	 * @return An {@link Optional} {@code String} describing this {@link Attachment}.
	 */
	Optional<String> getSummary();
	
	/**
	 * @return An {@link Optional} {@code String} representing a MIME type.
	 * @see https://en.wikipedia.org/wiki/Internet_media_type
	 */
	Optional<String> getMimeType();
	
	/**
	 * @return An {@link Optional} {@code String} identifying the attachment creator.
	 */
	Optional<String> getCreator();
	
}
