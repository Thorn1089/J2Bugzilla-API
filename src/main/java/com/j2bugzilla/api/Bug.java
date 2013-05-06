package com.j2bugzilla.api;

import com.google.common.base.Optional;

/**
 * A {@code Bug} represents a particular item in a Bugzilla installation, commonly depicting a defect in
 * a piece of software, though many teams use reports in Bugzilla for new tasks and other scheduling items.
 * 
 * @author Tom
 */
public final class Bug {

	private final Optional<Integer> id;
	
	private Optional<String> priority;
	
	private Optional<String> severity;
	
	private Optional<String> alias;
	
	private Optional<String> summary;
	
	private Optional<String> product;
	
	private Optional<String> component;
	
	private Optional<String> version;
	
	private Optional<String> status;
	
	private Optional<String> resolution;
	
	private Optional<String> operatingSystem;
	
	private Optional<String> platform;
	
	//TODO Flags
	
	public Bug(int id) {
		this.id = Optional.of(id);
	}
	
	public Bug() {
		this.id = Optional.absent();
	}
	
	public Optional<Integer> getId() {
		return id;
	}
	
	public Optional<String> getPriority() {
		return priority;
	}
	
	public void setPriority(final String priority) {
		this.priority = Optional.fromNullable(priority);
	}

	public Optional<String> getSeverity() {
		return severity;
	}

	public void setSeverity(String severity) {
		this.severity = Optional.fromNullable(severity);
	}

	public Optional<String> getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = Optional.fromNullable(alias);
	}

	public Optional<String> getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = Optional.fromNullable(summary);
	}

	public Optional<String> getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = Optional.fromNullable(product);
	}

	public Optional<String> getComponent() {
		return component;
	}

	public void setComponent(String component) {
		this.component = Optional.fromNullable(component);
	}

	public Optional<String> getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = Optional.fromNullable(version);
	}

	public Optional<String> getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = Optional.fromNullable(status);
	}

	public Optional<String> getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = Optional.fromNullable(resolution);
	}

	public Optional<String> getOperatingSystem() {
		return operatingSystem;
	}

	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = Optional.fromNullable(operatingSystem);
	}

	public Optional<String> getPlatform() {
		return platform;
	}

	public void setPlatform(String platform) {
		this.platform = Optional.fromNullable(platform);
	}
	
	
}
