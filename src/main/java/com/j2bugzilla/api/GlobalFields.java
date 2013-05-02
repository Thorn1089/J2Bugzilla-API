package com.j2bugzilla.api;

/**
 * The {@code GlobalFields} enum represents bug attributes which are applicable across all products in the
 * Bugzilla installation. These attributes can be queried for their legal set of values.
 * 
 * @see ProductFields
 * @author Tom
 */
public enum GlobalFields {
	REP_PLATFORM("rep_platform"), 
	OP_SYS("op_sys"), 
	PRIORITY("priority"), 
	SEVERITY("bug_severity"), 
	STATUS("bug_status"), 
	RESOLUTION("resolution");
	
	private String internalName;
	
	/**
	 * Registers the internal name used by Bugzilla for this field.
	 * @param internalName A {@code String} representing this field.
	 */
	GlobalFields(String internalName) {
		this.internalName = internalName;
	}
	
	/**
	 * @return A {@code String} representing this field.
	 */
	public String getInternalName() {
		return internalName;
	}
}
