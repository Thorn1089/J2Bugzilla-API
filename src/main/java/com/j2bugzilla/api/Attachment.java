package com.j2bugzilla.api;

import java.util.Arrays;
import java.util.Date;

import com.google.common.base.Optional;

/**
 * The {@code Attachment} class represents a file which is associated with one or more
 * {@link Bug} reports.
 * 
 * @author Tom
 */
public final class Attachment {

	private final Optional<Integer> attachmentId;
	
	private final Optional<Integer> bugId;
	
	private final String name;
	
	private final byte[] data;
	
	private Optional<String> summary = Optional.absent();
	
	private Optional<String> mime = Optional.absent();
	
	private Optional<String> creator = Optional.absent();
	
	private Optional<Date> createdOn = Optional.absent();
	
	private Optional<Date> modifiedOn = Optional.absent();
	
	/**
	 * Creates a new {@code Attachment} object representing file data to associate with a bug report.
	 * @param name A {@code String} name for the attached file data.
	 * @param data A {@code byte} array containing the file data.
	 */
	public Attachment(final String name, final byte[] data) {
		this.name = name;
		this.data = Arrays.copyOf(data, data.length);
		this.attachmentId = Optional.absent();
		this.bugId = Optional.absent();
	}
	
	/**
	 * Creates a new {@code Attachment} object representing file data to associate with a bug report.
	 * @param name A {@code String} name for the attached file data.
	 * @param data A {@code byte} array containing the file data.
	 * @param attachmentId An {@code int} identifying the attachment in the remote Bugzilla installation.
	 * @param bugId An {@code int} identifying the bug this attachment was posted to in the remote Bugzilla installation.
	 */
	public Attachment(final String name, final byte[] data, final int attachmentId, final int bugId, final Date createdOn, final Date modifiedOn) {
		this.name = name;
		this.data = Arrays.copyOf(data, data.length);
		this.attachmentId = Optional.of(attachmentId);
		this.bugId = Optional.of(bugId);
		this.createdOn = Optional.of(createdOn);
		this.modifiedOn = Optional.of(modifiedOn);
	}
	
	/**
	 * @return An {@link  Optional} {@code Integer} identifying this attachment. Absent if the attachment has not been persisted with a remote
	 * Bugzilla installation.
	 */
	public Optional<Integer> getAttachmentId() {
		return attachmentId;
	}
	
	/**
	 * @return An {@link Optional} {@code Integer} identifying the {@link Bug} this attachment is associated with. Absent if the attachment has not
	 * been persisted with a remote Bugzilla installation.
	 */
	public Optional<Integer> getBugId() {
		return bugId;
	}
	
	/**
	 * @return A {@code String} naming this {@link Attachment}.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return An array of {@code byte} data that this {@link Attachment} represents. Changes to the array are not written through to the attachment.
	 */
	public byte[] getData() {
		return Arrays.copyOf(data, data.length);
	}
	
	public Optional<Date> getCreationDate() {
		return createdOn;
	}
	
	public Optional<Date> getModificationDate() {
		return modifiedOn;
	}
	
	/**
	 * Sets the summary of this {@link Attachment}.
	 * @param summary A short, descriptive {@code String} for this file.
	 */
	public void setSummary(final String summary) {
		this.summary = Optional.fromNullable(summary);
	}
	
	/**
	 * @return An {@link Optional} {@code String} describing this {@link Attachment}.
	 */
	public Optional<String> getSummary() {
		return summary;
	}
	
	/**
	 * @param mime A {@code String} representing a MIME type.
	 * @see https://en.wikipedia.org/wiki/Internet_media_type
	 */
	public void setMimeType(final String mime) {
		this.mime = Optional.fromNullable(mime);
	}
	
	/**
	 * @return An {@link Optional} {@code String} representing a MIME type.
	 * @see https://en.wikipedia.org/wiki/Internet_media_type
	 */
	public Optional<String> getMimeType() {
		return mime;
	}
	
	/**
	 * Sets the creator of this {@link Attachment}.
	 * @param creator A {@code String} identifying the attachment submitter.
	 */
	public void setCreator(final String creator) {
		this.creator = Optional.fromNullable(creator);
	}
	
	/**
	 * @return An {@link Optional} {@code String} identifying the attachment creator.
	 */
	public Optional<String> getCreator() {
		return creator;
	}
	
}
