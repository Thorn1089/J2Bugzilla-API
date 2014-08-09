package com.j2bugzilla.api;

import java.util.Set;

import javax.annotation.Nonnull;

/**
 * The {@link BugzillaConnection} defines the main point of interaction with a Bugzilla installation.
 * It provides 'global' functionality such as login and logout. This interface makes no guarantees about
 * thread safety -- implementations are free to require external synchronization in order to optimize
 * performance for the case where a connection is not shared among multiple threads.
 * 
 * Authenticating via the login call, or clearing credentials via the logout call, returns a new instance
 * of the connection, which should be used for further calls.
 * 
 * @author Tom
 *
 */
public interface BugzillaConnection {

	/**
	 * Retrieves a configured instance of {@link BugRepository} to allow consumers to make queries about
	 * {@link Bug bugs}, create new bugs, or update existing bugs.
	 * @return A {@code BugRepository} implementation provided by the bound SPI provider.
	 */
	@Nonnull
	BugRepository getBugRepository();
	
	/**
	 * Retrieves a configured instance of {@link AttachmentRepository} to allow consumers to make queries
	 * about {@link Attachment attachments} or upload new ones.
	 * @return A {@code AttachmentRepository} implementation returned by the bound SPI provider.
	 */
	@Nonnull
	AttachmentRepository getAttachmentRepository();
	
	/**
	 * Retrieves a configured instance of {@link CommentRepository} to allow consumers to make queries
	 * about {@link Comment comments} or add new ones.
	 * @return A {@code CommentRepository} implementation returned by the bound SPI provider.
	 */
	@Nonnull
	CommentRepository getCommentRepository();
	
	/**
	 * Retrieves a configured instance of {@link ProductRepository} to allow consumers to make queries
	 * about {@link Product products}, update existing or add new ones.
	 * @return A {@code ProductRepository} implementation returned by the bound SPI provider.
	 */
	@Nonnull
	ProductRepository getProductRepository();
	
	/**
	 * Retrieves the legal values for the given field.
	 * @param field A {@link GlobalFields field} to look up values for.
	 * @return A {@code Set} of {@code Strings} which can be assigned to the given field.
	 */
	@Nonnull
	Set<String> getLegalValuesFor(GlobalFields field);
	
	/**
	 * Gets the version of the remote Bugzilla installation.
	 * @return A {@code String} representing the software version.
	 */
	@Nonnull
	String getVersion();
	
	/**
	 * Retrieves the set of products the current user has access to.
	 * @return A {@code Set} of {@link Product} objects.
	 */
	@Nonnull
	Set<Product> getAccessibleProducts();
	
	/**
	 * Logs the given user in with the provided credentials. Subsequent requests via the returned connection
	 * will be made in the context of that user's permissions. If called when a user is already logged in, 
	 * the results are implementation-specific and considered undefined. For example, after logging in as 
	 * user A, an attempt to log in again as user B may have no effect, throw a runtime exception, or any other 
	 * side effect as dictated by the implementation.
	 * 
	 * @param user A {@code String} representing a username, typically as an email address.
	 * @param pass A {@code String} representing the user's password.
	 * @return A {@link BugzillaConnection} encapsulating the user's login credentials, which should be used
	 * for all further requests.
	 */
	@Nonnull
	BugzillaConnection logIn(String user, String pass);
	
	/**
	 * Logs the current user out. Subsequent requests via the returned connection will be made anonymously. 
	 * If called when no user is logged in, the results are implementation-specific; however, implementations 
	 * should attempt to ensure this call is idempotent.
	 */
	@Nonnull
	BugzillaConnection logOut();
	
}
