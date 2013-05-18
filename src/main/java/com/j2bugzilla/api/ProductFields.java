package com.j2bugzilla.api;

/**
 * The {@code ProductFields} enum represents bug attributes which differ depending on the context of the
 * {@link Product} for a bug. These attributes can be queried for their set of legal values.
 * 
 * @author Tom
 */
public enum ProductFields {
	/**
	 * Different modules within a product, such as 'database' or 'UI'.
	 */
	COMPONENT("component"), 
	/**
	 * Versions of a product, such as '3.1' or '95'.
	 */
	VERSION("version");
	
	private String internalName;
	
	/**
	 * Registers the internal name used by Bugzilla for this field.
	 * @param internalName A {@code String} representing this field.
	 */
	ProductFields(String internalName) {
		this.internalName = internalName;
	}
	
	/**
	 * @return A {@code String} representing this field.
	 */
	public String getInternalName() {
		return internalName;
	}
}
