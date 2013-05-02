package com.j2bugzilla.api;

import com.google.common.base.Optional;

/**
 * A {@code Comment} represents additional information added to a {@link Bug} report by a user.
 * Multiple comments typically represent a dialogue between reporters, developers, QA, and other
 * stakeholders.
 * 
 * @author Tom
 */
public final class Comment {

	private final Optional<Integer> id;
	
	private final String text;
	
	public Comment(int id, String text) {
		this.id = Optional.of(id);
		this.text = text;
	}
	
	public Optional<Integer> getID() {
		return id;
	}
	
	public String getText() {
		return text;
	}
	
}
