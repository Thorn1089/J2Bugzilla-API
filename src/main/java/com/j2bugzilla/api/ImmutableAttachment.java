package com.j2bugzilla.api;

import java.time.Instant;
import java.util.Arrays;
import java.util.Optional;

final class ImmutableAttachment implements Attachment {

	private final Integer attachmentId;
	
	private final Integer bugId;
	
	private final String name;
	
	private final byte[] data;
	
	private final Instant creationDate;
	
	private final Instant modificationDate;
	
	private final String summary;
	
	private final String mime;
	
	private final String creator;
	
	ImmutableAttachment(final Integer attachmentId, final Integer bugId, final String name,
			final byte[] data, final Instant creationDate, final Instant modificationDate,
			final String summary, final String mime, final String creator) {
		this.attachmentId = attachmentId;
		this.bugId = bugId;
		this.name = name;
		this.data = Arrays.copyOf(data, data.length);
		this.creationDate = creationDate;
		this.modificationDate = modificationDate;
		this.summary = summary;
		this.mime = mime;
		this.creator = creator;
	}
	
	@Override
	public Optional<Integer> getAttachmentId() {
		return Optional.ofNullable(attachmentId);
	}

	@Override
	public Optional<Integer> getBugId() {
		return Optional.ofNullable(bugId);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public byte[] getData() {
		return Arrays.copyOf(data, data.length);
	}

	@Override
	public Optional<Instant> getCreationDate() {
		return Optional.ofNullable(creationDate);
	}

	@Override
	public Optional<Instant> getModificationDate() {
		return Optional.ofNullable(modificationDate);
	}

	@Override
	public Optional<String> getSummary() {
		return Optional.ofNullable(summary);
	}

	@Override
	public Optional<String> getMimeType() {
		return Optional.ofNullable(mime);
	}

	@Override
	public Optional<String> getCreator() {
		return Optional.ofNullable(creator);
	}

}
