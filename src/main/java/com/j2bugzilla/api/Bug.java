package com.j2bugzilla.api;

import com.google.common.base.Optional;

/**
 * <p>
 * A {@code Bug} represents a particular item in a Bugzilla installation, commonly depicting a defect in
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
 * @author Tom
 */
public final class Bug {

	private final Optional<Integer> id;
	
	private Optional<String> priority;
	
	private Optional<String> severity;
	
	private Optional<String> alias;
	
	private Optional<String> summary;
	
	private Optional<Product> product;
	
	private Optional<String> component;
	
	private Optional<String> version;
	
	private Optional<String> status;
	
	private Optional<String> resolution;
	
	private Optional<String> operatingSystem;
	
	private Optional<String> platform;
	
	//TODO Flags
	
	/**
	 * Creates a {@link Bug} with the given ID. Typically called when a bug is deserialized from a remote
	 * procedure call, but can be used if the client knows the bug ID.
	 * @param id A {@code int} identifying this {@code Bug}.
	 */
	public Bug(int id) {
		this.id = Optional.of(id);
	}
	
	/**
	 * Creates a {@link Bug} with an absent ID. Typically used when a client is creating a new {@code Bug}
	 * to report via {@link BugRepository#create(Bug)}.
	 */
	public Bug() {
		this.id = Optional.absent();
	}
	
	/**
	 * @return An {@link Optional} {@code int} identifying this {@link Bug}.
	 */
	public Optional<Integer> getId() {
		return id;
	}
	
	/**
	 * @return An {@link Optional} {@code String} describing this {@link Bug bug's} relative priority.
	 */
	public Optional<String> getPriority() {
		return priority;
	}
	
	/**
	 * Sets the relative priority of this {@link Bug}.
	 * @param priority A {@code String} describing this bug's priority level.
	 */
	public void setPriority(final String priority) {
		this.priority = Optional.fromNullable(priority);
	}

	/**
	 * @return An {@link Optional} {@code String} describing the relative severity of this {@link Bug}.
	 */
	public Optional<String> getSeverity() {
		return severity;
	}

	/**
	 * Sets the relative severity of this {@link Bug}.
	 * @param severity A {@code String} describing this bug's severity level.
	 */
	public void setSeverity(String severity) {
		this.severity = Optional.fromNullable(severity);
	}

	/**
	 * @return An {@link Optional} {@code String} which can be used to uniquely identify this {@link Bug} in place of an ID. Not available on all
	 * Bugzilla installations.
	 */
	public Optional<String> getAlias() {
		return alias;
	}

	/**
	 * Gives this {@link Bug} a unique alias which can be used in place of an ID. If the alias is not unique, it will be rejected once the bug is
	 * updated.
	 * @param alias A {@code String} used to identify this bug.
	 */
	public void setAlias(String alias) {
		this.alias = Optional.fromNullable(alias);
	}

	/**
	 * @return An {@link Optional} one-line {@code String} describing this {@link Bug}. 
	 */
	public Optional<String> getSummary() {
		return summary;
	}

	/**
	 * Sets the summary for this {@link Bug}.
	 * @param summary A single-line {@code String}. 
	 */
	//TODO Define behavior when passed a string with line separators
	public void setSummary(String summary) {
		this.summary = Optional.fromNullable(summary);
	}

	/**
	 * @return An {@link Optional} {@code Product} this bug belongs to.
	 */
	public Optional<Product> getProduct() {
		return product;
	}

	/**
	 * Sets the {@link Product} for this {@link Bug}.
	 * @param product A {@code Product} this {@code Bug} belongs to.
	 */
	public void setProduct(Product product) {
		this.product = Optional.fromNullable(product);
	}

	/**
	 * @return An {@link Optional} {@code String} describing the component this {@link Bug} belongs to.
	 */
	public Optional<String> getComponent() {
		return component;
	}

	/**
	 * Sets the component for this {@link Bug}.
	 * @param component A {@code String} describing the component this {@code Bug} belongs to.
	 */
	public void setComponent(String component) {
		this.component = Optional.fromNullable(component);
	}

	/**
	 * Returns a {@code String} representing the product version.
	 * @return An {@link Optional} {@code String} describing the product version this {@link Bug} affects. 
	 */
	public Optional<String> getVersion() {
		return version;
	}

	/**
	 * Sets the product version {@code String} associated with this {@link Bug}.
	 * Legal values are dependent on the current {@link Product} associated with this bug, and can be 
	 * retrieved via {@link ProductRepository#getLegalValuesFor(ProductFields, Product)}.
	 * @param version A {@code String} describing the product version this {@code Bug} affects.
	 */
	public void setVersion(String version) {
		this.version = Optional.fromNullable(version);
	}

	/**
	 * @return An {@link Optional} {@code String} representing the status of this {@link Bug}.
	 */
	public Optional<String> getStatus() {
		return status;
	}

	/**
	 * Sets the status {@code String} associated with this {@link Bug}.
	 * Legal values are dependent on the installation, and can be retrieved via {@link Bugzilla#getLegalValuesFor(GlobalFields)}.
	 * @param status A {@code String} describing the current status of this {@code Bug}.
	 */
	public void setStatus(String status) {
		this.status = Optional.fromNullable(status);
	}

	/**
	 * @return An {@link Optional} {@code String} representing the resolution of this {@link Bug}. May be absent depending on the
	 * {@link #status} of the bug.
	 */
	public Optional<String> getResolution() {
		return resolution;
	}

	/**
	 * Sets the resolution {@code String} associated with this {@link Bug}.
	 * Legal values are dependent on the installation, and can be retrieved via {@link Bugzilla#getLegalValuesFor(GlobalFields)}; additionally,
	 * resolutions can only be applied when bugs have certain {@link #status statuses}.
	 * @param resolution A {@code String} describing how this {@code Bug} was resolved.
	 */
	public void setResolution(String resolution) {
		this.resolution = Optional.fromNullable(resolution);
	}

	/**
	 * @return An {@link Optional} {@code String} describing the operating system this {@link Bug} was observed on.
	 */
	public Optional<String> getOperatingSystem() {
		return operatingSystem;
	}

	/**
	 * Sets the operating system {@code String} this {@link Bug} was observed on.
	 * Legal values are dependent on the installation, and can be retrieved via {@link Bugzilla#getLegalValuesFor(GlobalFields)}.
	 * @param operatingSystem A {@code String} describing the operating system where the {@code Bug} was observed.
	 */
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = Optional.fromNullable(operatingSystem);
	}

	/**
	 * @return An {@link Optional} {@code String} describing the hardware this {@link Bug} was observed on.
	 */
	public Optional<String> getPlatform() {
		return platform;
	}

	/**
	 * Sets the hardware {@code String} this {@link Bug} was observed on.
	 * Legal values are dependent on the installation, and can be retrieved via {@link Bugzilla#getLegalValuesFor(GlobalFields)}.
	 * @param platform A {@code String} describing the hardware where the {@code Bug} was observed.
	 */
	public void setPlatform(String platform) {
		this.platform = Optional.fromNullable(platform);
	}
	
	
}
