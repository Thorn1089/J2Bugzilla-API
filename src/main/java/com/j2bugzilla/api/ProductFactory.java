package com.j2bugzilla.api;

public final class ProductFactory {

	public static ProductFactory newFactory() {
		return new ProductFactory();
	}
	
	private Integer id;
	
	private String name;
	
	private String description;
	
	private ProductFactory() {
		
	}
	
	public Product create() {
		return new ImmutableProduct(id, name, description);
	}
	
	public ProductFactory setId(final Integer id) {
		this.id = id;
		return this;
	}
	
	public ProductFactory setName(final String name) {
		this.name = name;
		return this;
	}
	
	public ProductFactory setDescription(final String description) {
		this.description = description;
		return this;
	}
	
}
