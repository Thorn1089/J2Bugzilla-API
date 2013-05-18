package com.j2bugzilla.api;

/**
 * The {@code GlobalFields} enum represents bug attributes which are applicable across all products in the
 * Bugzilla installation. These attributes can be queried for their legal set of values.
 * 
 * @see ProductFields
 * @author Tom
 */
public enum GlobalFields {
	/**
	 * Hardware platforms, such as 'PC' or 'Macintosh'.
	 */
	REP_PLATFORM("rep_platform"), 
	/**
	 * Operating systems, such as 'Windows 8' or 'OSX Mountain Lion'.
	 */
	OP_SYS("op_sys"), 
	/**
	 * Bug priorities, such as 'P1'.
	 */
	PRIORITY("priority"), 
	/**
	 * Bug severities, such as 'Major' or 'Severe'.
	 */
	SEVERITY("bug_severity"), 
	/**
	 * Bug statuses, such as 'Open' or 'In progress'.
	 */
	STATUS("bug_status"), 
	/**
	 * Bug outcomes, such as 'Fixed' or 'Needs confirmation'.
	 */
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
