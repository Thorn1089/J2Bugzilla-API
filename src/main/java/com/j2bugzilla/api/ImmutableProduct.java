package com.j2bugzilla.api;

import java.util.Optional;

final class ImmutableProduct implements Product {

	private final Integer id;
	
	private final String name;
	
	private final String description;
	
	ImmutableProduct(final Integer id, final String name, final String description) {
		this.id = id;
		this.name = name;
		this.description = description;
	}
	
	@Override
	public Optional<Integer> getID() {
		return Optional.ofNullable(id);
	}

	@Override
	public String getName() {
		return name;
	}

	@Override
	public String getDescription() {
		return description;
	}

}
