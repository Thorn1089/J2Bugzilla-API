package com.j2bugzilla.api;

import com.google.common.base.Optional;

/**
 * A {@code Product} represents a classification of bugs within Bugzilla, which all belong to the same
 * taxonomy of software. Products typically are correlated with actual salable products, e.g. 'Microsoft
 * Excel' or 'Mozilla Firefox.'
 * 
 * @author Tom
 */
public final class Product {

	private final Optional<Integer> id;
	
	public Product(int id) {
		this.id = Optional.of(id);
	}
	
	public Optional<Integer> getID() {
		return id;
	}
	
}
