package com.j2bugzilla.api;

import java.util.Collections;
import java.util.Map;
import java.util.Optional;

final class ImmutableBug implements Bug {

	static final String PRIORITY = "priority";
	static final String SEVERITY = "severity";
	static final String ALIAS = "alias";
	static final String SUMMARY = "summary";
	static final String COMPONENT = "component";
	static final String VERSION = "version";
	static final String STATUS = "status";
	static final String RESOLUTION = "resolution";
	static final String OPERATING_SYSTEM = "operating_system";
	static final String PLATFORM = "platform";
	
	private final Integer id;
	
	private final Product product;
	
	private final Map<String, String> fields;
	
	ImmutableBug(final Integer id, final Product product, final Map<String, String> fields) {
		this.id = id;
		this.product = product;
		this.fields = Collections.unmodifiableMap(fields);
	}
	
	@Override
	public Optional<Integer> getId() {
		return Optional.ofNullable(id);
	}

	@Override
	public Optional<String> getPriority() {
		return Optional.ofNullable(fields.get(PRIORITY));
	}

	@Override
	public Optional<String> getSeverity() {
		return Optional.ofNullable(fields.get(SEVERITY));
	}

	@Override
	public Optional<String> getAlias() {
		return Optional.ofNullable(fields.get(ALIAS));
	}

	@Override
	public Optional<String> getSummary() {
		return Optional.ofNullable(fields.get(SUMMARY));
	}

	@Override
	public Optional<Product> getProduct() {
		return Optional.ofNullable(product);
	}

	@Override
	public Optional<String> getComponent() {
		return Optional.ofNullable(fields.get(COMPONENT));
	}

	@Override
	public Optional<String> getVersion() {
		return Optional.ofNullable(fields.get(VERSION));
	}

	@Override
	public Optional<String> getStatus() {
		return Optional.ofNullable(fields.get(STATUS));
	}

	@Override
	public Optional<String> getResolution() {
		return Optional.ofNullable(fields.get(RESOLUTION));
	}

	@Override
	public Optional<String> getOperatingSystem() {
		return Optional.ofNullable(fields.get(OPERATING_SYSTEM));
	}

	@Override
	public Optional<String> getPlatform() {
		return Optional.ofNullable(fields.get(PLATFORM));
	}

}
