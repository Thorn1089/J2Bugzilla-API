package com.j2bugzilla.api;

import java.util.List;
import java.util.Set;

/**
 * The {@code CommentRepository} allows consumers to retrieve {@link Comment comments}
 * from existing {@link Bug} reports and add new comments to bugs.
 * 
 * @author Tom
 */
public interface CommentRepository {

	/**
	 * Adds a new comment to an existing bug.
	 * @param bug A {@link Bug} to comment on.
	 * @param comment A {@link Comment} including the text to add from the current user.
	 * @return An {@code int} identifying the new comment.
	 */
	int commentOn(Bug bug, Comment comment);
	
	/**
	 * Retrieves the identified comment, or throws an exception if no such comment exists.
	 * @param id An {@code int} identifying a comment.
	 * @return A {@link Comment} if one exists.
	 */
	Comment get(int id);
	
	/**
	 * Returns a {@code Set} of comments identified by the given IDs. If nonexistent IDs are specified,
	 * they are ignored.
	 * @param ids A set of {@code ints} identifying comments.
	 * @return A set of {@link Comment} objects.
	 */
	Set<Comment> getAll(int... ids);
	
	/**
	 * Gets an ordered {@code List} of comments representing the chronological thread of discusson on
	 * a single bug. The provided bug must have an ID; otherwise, an exception is thrown.
	 * @param bug A {@link Bug} to retrieve the discussion history for.
	 * @return A list of {@link Comment} objects.
	 */
	List<Comment> getThreadFor(Bug bug);
	
}
