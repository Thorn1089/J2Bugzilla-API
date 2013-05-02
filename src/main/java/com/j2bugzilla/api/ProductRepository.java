package com.j2bugzilla.api;

import java.util.Set;

import com.google.common.base.Optional;

/**
 * The {@code ProductRepository} allows for {@link Product} information to be retrieved, and new products
 * to be created in a remote Bugzilla installation.
 * 
 * @author Tom
 */
public interface ProductRepository {

	/**
	 * Creates a new {@link Product} in the remote installation, which has the properties described by the
	 * given object.
	 * @param product A {@code Product} to create.
	 */
	void create(Product product);
	
	/**
	 * Returns a {@link Product} identified by the given {@code int}, or an absent {@link Optional}
	 * if no such product exists.
	 * @param id An {@code int} identifying a specific product.
	 * @return A {@code Product} from the remote installation.
	 */
	Optional<Product> get(int id);
	
	/**
	 * Retrieves the set of all products identified. If nonexistent IDs are given, they will be ignored.
	 * @param ids A set of {@code int} IDs.
	 * @return A {@code Set} of {@link Product} instances found.
	 */
	Set<Product> getAll(int... ids);
	
	/**
	 * Updates the given {@link Product} in the remote installation to match the given instance.
	 * @param product A {@code Product} to update.
	 */
	void update(Product product);
	
	/**
	 * Retrieves the legal values which can be assigned to the given field for the specified product.
	 * @param field A {@link ProductField} to look up values for
	 * @param product The {@link Product} to retrieve legal values in the context of.
	 * @return A {@code Set} of {@code String} values for the field.
	 */
	Set<String> getLegalValuesFor(ProductFields field, Product product);
}
