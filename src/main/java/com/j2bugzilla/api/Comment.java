package com.j2bugzilla.api;

import java.util.Optional;

/**
 * A {@code Comment} represents additional information added to a {@link Bug} report by a user.
 * Multiple comments typically represent a dialogue between reporters, developers, QA, and other
 * stakeholders.
 * 
 * @author Tom
 */
public interface Comment {
	
	/**
	 * @return An {@link Optional} {@code Integer} identifying this {@link Comment}, if it exists
	 * within a remote installation.
	 */
	Optional<Integer> getID();
	
	/**
	 * @return A {@code String} containing the text of this comment.
	 */
	String getText();
	
}
