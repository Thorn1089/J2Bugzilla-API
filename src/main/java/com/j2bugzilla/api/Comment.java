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
	
	/**
	 * Creates a new {@link Comment} with the given ID and content.
	 * @param id An {@code int} uniquely identifying this comment with the remote installation.
	 * @param text A {@code String} containing the text of this comment.
	 */
	public Comment(final int id, final String text) {
		this.id = Optional.of(id);
		this.text = text;
	}
	
	/**
	 * Creates a new {@link Comment} not associated with a remote installation.
	 * @param text A {@code String} containing the text of this comment.
	 */
	public Comment(final String text) {
		this.id = Optional.absent();
		this.text = text;
	}
	
	/**
	 * @return An {@link Optional} {@code Integer} identifying this {@link Comment}, if it exists
	 * within a remote installation.
	 */
	public Optional<Integer> getID() {
		return id;
	}
	
	/**
	 * @return A {@code String} containing the text of this comment.
	 */
	public String getText() {
		return text;
	}
	
}
