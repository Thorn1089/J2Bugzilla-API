package com.j2bugzilla.api;

import java.util.Optional;

final class ImmutableComment implements Comment {

	private final Integer id;
	
	private final String text;
	
	ImmutableComment(final Integer id, final String text) {
		this.id = id;
		this.text = text;
	}
	
	@Override
	public Optional<Integer> getID() {
		return Optional.ofNullable(id);
	}

	@Override
	public String getText() {
		return text;
	}

}
