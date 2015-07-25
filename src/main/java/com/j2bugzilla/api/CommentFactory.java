package com.j2bugzilla.api;

public final class CommentFactory {

	public static CommentFactory newFactory() {
		return new CommentFactory();
	}
	
	private CommentFactory() {
		
	}
	
	private Integer id;
	
	private String text;
	
	public Comment create() {
		return new ImmutableComment(id, text);
	}
	
	public CommentFactory setId(final Integer id) {
		this.id = id;
		return this;
	}
	
	public CommentFactory setText(final String text) {
		this.text = text;
		return this;
	}
	
}
