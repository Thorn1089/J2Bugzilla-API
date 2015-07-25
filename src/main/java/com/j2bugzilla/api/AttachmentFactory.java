package com.j2bugzilla.api;

import java.time.Instant;

public final class AttachmentFactory {

	public static AttachmentFactory newFactory() {
		return new AttachmentFactory();
	}
	
	private Integer attachmentId;
	
	private Integer bugId;
	
	private String name;
	
	private byte[] data;
	
	private Instant creationDate;
	
	private Instant modificationDate;
	
	private String summary;
	
	private String mime;
	
	private String creator;
	
	private AttachmentFactory() {
		
	}
	
	public Attachment create() {
		return new ImmutableAttachment(attachmentId, bugId, name, data, creationDate, modificationDate, summary, mime, creator);
	}
	
	public AttachmentFactory setAttachmentId(final Integer attachmentId) {
		this.attachmentId = attachmentId;
		return this;
	}
	
	public AttachmentFactory setBugId(final Integer bugId) {
		this.bugId = bugId;
		return this;
	}
	
	public AttachmentFactory setName(final String name) {
		this.name = name;
		return this;
	}
	
	public AttachmentFactory setData(final byte[] data) {
		this.data = data;
		return this;
	}
	
	public AttachmentFactory setCreationDate(final Instant creationDate) {
		this.creationDate = creationDate;
		return this;
	}
	
	public AttachmentFactory setModificationDate(final Instant modificationDate) {
		this.modificationDate = modificationDate;
		return this;
	}
	
	public AttachmentFactory setSummary(final String summary) {
		this.summary = summary;
		return this;
	}
	
	public AttachmentFactory setMime(final String mime) {
		this.mime = mime;
		return this;
	}
	
	public AttachmentFactory setCreator(final String creator) {
		this.creator = creator;
		return this;
	}
	
}
