package com.j2bugzilla.api;

/**
 * The {@code SearchBy} enum provides a type-safe listing of all available search parameters in a Bugzilla
 * installation.
 * 
 * @author Tom
 */
public enum SearchBy {

	/**
	 * The email of the assignee
	 */
	OWNER("assigned_to"), 
	
	/**
	 * The email of the reporting user
	 */
	REPORTER("reporter"), 
	
	/**
	 * The {@link jbugz.base.Bug.Status} field value
	 */
	STATUS("status"),
	
	/**
	 * The resolution field, if the bug's status is closed. You can search
	 * for all open bugs by searching for a blank resolution.
	 */
	RESOLUTION("resolution"),
	
	/**
	 * The {@link jbugz.base.Bug.Priority} field value
	 */
	PRIORITY("priority"), 
	
	/**
	 * The product affected by this bug
	 */
	PRODUCT("product"),
	
	/**
	 * The component affected by this bug
	 */
	COMPONENT("component"),
	
	/**
	 * The operating system affected by this bug
	 */
	OPERATING_SYSTEM("op_sys"),
	
	/**
	 * The hardware affected by this bug
	 */
	PLATFORM("platform"),
	
	/**
	 * The initial summary comment
	 */
	SUMMARY("summary"),
	
	/**
	 * The version affected by this bug
	 */
	VERSION("version"),
	
	/**
	 * The unique alias for a bug
	 */
	ALIAS("alias"),
	
	/**
	 * The maximum number of bugs to return.
	 */
	LIMIT("limit"),
	
	/**
	 * An offset into bugs returned by search.
	 */
	OFFSET("offset"); 
	
	private final String name;
	/**
	 * Creates a new {@link SearchLimiter} with the
	 * designated name
	 * @param name The name Bugzilla expects for this search limiter
	 */
	private SearchBy(String name) {
		this.name = name;
	}
	/**
	 * Get the name Bugzilla expects for this search limiter
	 * @return A <code>String</code> representing the search limiter
	 */
	public String getName() {
		return this.name;
	}
	
}
