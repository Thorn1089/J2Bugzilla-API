package com.j2bugzilla.api;

import java.util.Set;

/**
 * The {@code BugRepository} interface defines a CRUD-style class which allows {@link Bug Bugs} to be
 * created, modified, and searched from a particular Bugzilla installation.
 * 
 * @author Tom
 */
public interface BugRepository {

	/**
	 * Creates a new {@link Bug} report in the associated installation, which has the properties described
	 * by the given bug.
	 * @param bug A {@code Bug} to create on a remote installation.
	 * @return An {@code int} identifying the newly-created bug.
	 */
	int create(Bug bug);
	
	/**
	 * Retrieves a {@link Bug} with the given ID. If no such bug is found, an exception is thrown.
	 * @param id An {@code int} identifying a bug.
	 * @return The {@code Bug} uniquely identified by the provided ID.
	 */
	Bug get(int id);
	
	/**
	 * Retrieves all {@link Bug Bugs} matching the given set of IDs. If a given ID does not match a bug, it
	 * is ignored.
	 * @param ids One or more {@code ints} identifying {@code Bugs}.
	 * @return A {@code Set} of {@code Bug} objects.
	 */
	Set<Bug> getAll(int... ids);
	
	/**
	 * Synchronizes the state of a {@link Bug} with the associated Bugzilla instance.
	 * The provided bug must have an ID; otherwise, an exception is thrown.
	 * @param bug A {@code Bug} to update.
	 */
	void update(Bug bug);
	
	/**
	 * Searches for bugs matching <em>all</em> of the given {@link SearchParam search parameters}.
	 * @param params A set of {@code SearchParam} objects to narrow results by.
	 * @return A {@code Set} of matching {@link Bug bugs}.
	 */
	Set<Bug> search(SearchParam... params);
}
