package com.j2bugzilla.api;

import java.util.Optional;

/**
 * <p>
 * A {@link Bug} represents a particular item in a Bugzilla installation, commonly depicting a defect in
 * a piece of software, though many teams use reports in Bugzilla for new tasks and other scheduling items.
 * </p>
 * <p>
 * All fields returned by the {@code Bug} class are marked as {@link Optional}, since they may have not yet
 * been set by the client, or do not have a representation on the server. For example, the 
 * {@link #resolution} field has no meaning when a {@code Bug} is not in a {@link #status} considered 'closed.'
 * Some fields may additionally be customized by administrators, meaning they cannot be assigned enumerated
 * values. Clients should avail themselves of the {@link Bugzilla#getLegalValuesFor(GlobalFields)} method and
 * its counterpart, {@link ProductRepository#getLegalValuesFor(ProductFields, Product)}.
 * </p>
 * <p>
 * Fields which are required are handled by individual methods on the corresponding repository. For example,
 * submitting a {@code Bug} which is missing fields to {@link BugRepository#create(Bug)} will throw an exception.
 * </p>
 * <p>
 * Creating a new bug can be done via a {@link BugFactory}, either from scratch or by cloning an existing bug via
 * {@link BugFactory#newBuilder(Bug)}.
 * </p>
 * @author Tom
 */
public interface Bug {
	
	//TODO Flags
	
	/**
	 * @return An {@link Optional} {@code int} identifying this {@link Bug}.
	 */
	Optional<Integer> getId();
	
	/**
	 * @return An {@link Optional} {@code String} describing this {@link Bug bug's} relative priority.
	 */
	Optional<String> getPriority();

	/**
	 * @return An {@link Optional} {@code String} describing the relative severity of this {@link Bug}.
	 */
	Optional<String> getSeverity();

	/**
	 * @return An {@link Optional} {@code String} which can be used to uniquely identify this {@link Bug} in place of an ID. Not available on all
	 * Bugzilla installations.
	 */
	Optional<String> getAlias();

	/**
	 * @return An {@link Optional} one-line {@code String} describing this {@link Bug}. 
	 */
	Optional<String> getSummary();

	/**
	 * @return An {@link Optional} {@code Product} this bug belongs to.
	 */
	Optional<Product> getProduct();

	/**
	 * @return An {@link Optional} {@code String} describing the component this {@link Bug} belongs to.
	 */
	Optional<String> getComponent();

	/**
	 * Returns a {@code String} representing the product version.
	 * @return An {@link Optional} {@code String} describing the product version this {@link Bug} affects. 
	 */
	Optional<String> getVersion();

	/**
	 * @return An {@link Optional} {@code String} representing the status of this {@link Bug}.
	 */
	Optional<String> getStatus();

	/**
	 * @return An {@link Optional} {@code String} representing the resolution of this {@link Bug}. May be absent depending on the
	 * {@link #status} of the bug.
	 */
	Optional<String> getResolution();

	/**
	 * @return An {@link Optional} {@code String} describing the operating system this {@link Bug} was observed on.
	 */
	Optional<String> getOperatingSystem();

	/**
	 * @return An {@link Optional} {@code String} describing the hardware this {@link Bug} was observed on.
	 */
	Optional<String> getPlatform();
	
}
