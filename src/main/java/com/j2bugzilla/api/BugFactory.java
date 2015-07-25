package com.j2bugzilla.api;

import java.util.HashMap;
import java.util.Map;

public final class BugFactory {
	
	public static BugFactory newBuilder(final Bug bug) {
		return new BugFactory()
				.setId(bug.getId().orElse(null))
				.setProduct(bug.getProduct().orElse(null))
				.setPriority(bug.getPriority().orElse(null))
				.setSeverity(bug.getSeverity().orElse(null))
				.setAlias(bug.getAlias().orElse(null))
				.setSummary(bug.getSummary().orElse(null))
				.setComponent(bug.getComponent().orElse(null))
				.setVersion(bug.getVersion().orElse(null))
				.setStatus(bug.getStatus().orElse(null))
				.setResolution(bug.getResolution().orElse(null))
				.setOperatingSystem(bug.getOperatingSystem().orElse(null))
				.setPlatform(bug.getPlatform().orElse(null));
	}
	
	public static BugFactory newBuilder() {
		return new BugFactory();
	}
	
	private Integer id;
	
	private Product product;
	
	private final Map<String, String> fields = new HashMap<>();
	
	private BugFactory() {
		
	}
	
	public Bug create() {
		return new ImmutableBug(id, product, fields);
	}
	
	public BugFactory setId(final Integer id) {
		this.id = id;
		return this;
	}
	
	public BugFactory setProduct(final Product product) {
		this.product = product;
		return this;
	}
	
	public BugFactory setPriority(final String priority) {
		fields.put(ImmutableBug.PRIORITY, priority);
		return this;
	}
	
	public BugFactory setSeverity(final String severity) {
		fields.put(ImmutableBug.SEVERITY, severity);
		return this;
	}
	
	public BugFactory setAlias(final String alias) {
		fields.put(ImmutableBug.ALIAS, alias);
		return this;
	}
	
	public BugFactory setSummary(final String summary) {
		fields.put(ImmutableBug.SUMMARY, summary);
		return this;
	}
	
	public BugFactory setComponent(final String component) {
		fields.put(ImmutableBug.COMPONENT, component);
		return this;
	}
	
	public BugFactory setVersion(final String version) {
		fields.put(ImmutableBug.VERSION, version);
		return this;
	}
	
	public BugFactory setStatus(final String status) {
		fields.put(ImmutableBug.STATUS, status);
		return this;
	}
	
	public BugFactory setResolution(final String resolution) {
		fields.put(ImmutableBug.RESOLUTION, resolution);
		return this;
	}
	
	public BugFactory setOperatingSystem(final String operatingSystem) {
		fields.put(ImmutableBug.OPERATING_SYSTEM, operatingSystem);
		return this;
	}
	
	public BugFactory setPlatform(final String platform) {
		fields.put(ImmutableBug.PLATFORM, platform);
		return this;
	}
	
}
