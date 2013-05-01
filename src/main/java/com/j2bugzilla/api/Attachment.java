package com.j2bugzilla.api;

import com.google.common.base.Optional;

/**
 * The {@code Attachment} class represents a file which is associated with one or more
 * {@link Bug} reports.
 * 
 * @author Tom
 */
public final class Attachment {

	private final Optional<Integer> id;
	
	public Attachment(final int id) {
		this.id = Optional.of(id);
	}
	
	public Optional<Integer> getId() {
		return id;
	}
	
}
