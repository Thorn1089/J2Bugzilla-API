package com.j2bugzilla.api;

import java.util.Optional;

/**
 * A {@code Product} represents a classification of bugs within Bugzilla, which all belong to the same
 * taxonomy of software. Products typically are correlated with actual salable products, e.g. 'Microsoft
 * Excel' or 'Mozilla Firefox.'
 * 
 * @author Tom
 */
public interface Product {
	
	/**
	 * @return An {@link Optional} {@code Integer} identifying this {@link Product}.
	 */
	Optional<Integer> getID();
	
	/**
	 * @return A {@code String} naming this {@link Product}.
	 */
	String getName();
	
	/**
	 * @return A {@code String} describing this {@link Product}.
	 */
	String getDescription();
	
}
