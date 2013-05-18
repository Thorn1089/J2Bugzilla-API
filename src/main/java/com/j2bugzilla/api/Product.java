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
	
	private final String name;
	
	private final String description;
	
	/**
	 * Creates a new {@link Product} which exists in a remote installation.
	 * @param id An {@code int} which uniquely identifies this product.
	 * @param name A {@code String} naming the product.
	 * @param description A {@code String} describing the product.
	 */
	public Product(final int id, final String name, final String description) {
		this.id = Optional.of(id);
		this.name = name;
		this.description = description;
	}
	
	/**
	 * Creates a new {@link Product} not associated with any remote installation.
	 * @param name A {@code String} naming the product.
	 * @param description A {@code String} describing the product.
	 */
	public Product(final String name, final String description) {
		this.id = Optional.absent();
		this.name = name;
		this.description = description;
	}
	
	/**
	 * @return An {@link Optional} {@code Integer} identifying this {@link Product}.
	 */
	public Optional<Integer> getID() {
		return id;
	}
	
	/**
	 * @return A {@code String} naming this {@link Product}.
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return A {@code String} describing this {@link Product}.
	 */
	public String getDescription() {
		return description;
	}
	
}
