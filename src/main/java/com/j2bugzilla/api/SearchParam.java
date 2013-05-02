package com.j2bugzilla.api;

/**
 * The {@code SearchParam} class represents a portion of a search query. It includes a {@link SearchBy}
 * restriction which applies the given query string to a dimension of a {@link Bug}.
 * 
 * @author Tom
 */
public class SearchParam {

	private final SearchBy dimension;
	
	private final String query;
	
	/**
	 * Creates a new {@link SearchParam} with the given dimension and query value.
	 * @param dimension A {@link SearchBy} value to restrict the query.
	 * @param query A {@code String} which will be searched for in the given property.
	 */
	public SearchParam(final SearchBy dimension, final String query) {
		this.dimension = dimension;
		this.query = query;
	}
	
	/**
	 * @return A {@link SearchBy} enum representing the dimension of this search.
	 */
	public SearchBy getDimension() {
		return dimension;
	}
	
	/**
	 * @return A {@code String} which will be searched for.
	 */
	public String getQuery() {
		return query;
	}
	
}
