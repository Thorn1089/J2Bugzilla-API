package com.j2bugzilla.api;

import java.net.URI;
import java.util.ServiceLoader;
import java.util.Set;
import com.j2bugzilla.api.ConnectionException;

/**
 * The {@code Bugzilla} class is the entry point into the API. This class adheres to the SPI contract.
 * Implementations should extend it to provide access to the various domain object repositories and
 * methods.
 * 
 * @author Tom
 */
public abstract class Bugzilla{

	/**
	 * Loads and returns a new instance of {@link Bugzilla} to provide access to the various
	 * domain repositories and method implementations. The classpath will be searched by the Java
	 * {@link ServiceLoader} to create an appropriate SPI implementation. The first eligible implementation
	 * will be used, so if multiple implementation bindings are present on the classpath, the subtype of
	 * {@code Bugzilla} returned is nondeterministic.
	 * @return A {@code Bugzilla} instance retrieved by the SPI loader.
	 */
	public static final Bugzilla newBugzilla() {
		ServiceLoader<Bugzilla> loader = ServiceLoader.load(Bugzilla.class);
		if(loader.iterator().hasNext()) {
			return loader.iterator().next();
		} else {
			throw new IllegalStateException("No configured providers were found for Bugzilla");
		}
	}
	
	/**
	 * Connects to the given host.
	 * @param host A {@code String} which can be parsed as a URL, pointing to the Bugzilla base.
	 */
	public abstract void connectTo(String host) throws ConnectionException;
	
	/**
	 * Connects to the given host.
	 * @param host A {@link URI} which points to the Bugzilla base.
	 */
	public abstract void connectTo(URI host) throws ConnectionException;
	
	/**
	 * Connects to the given host, providing HTTP Basic authentication credentials. Note that this does
	 * not log you in with Bugzilla itself.
	 * @param host A {@code String} which can be parsed as a URL, pointing to the Bugzilla base.
	 * @param httpUser A {@code String} representing an HTTP Basic username.
	 * @param httpPass A {@code String} representing an HTTP Basic password.
	 */
	public abstract void connectTo(String host, String httpUser, String httpPass) throws ConnectionException;
	
	/**
	 * Connects to the given host, providing HTTP Basic authentication credentials. Note that this does
	 * not log you in with Bugzilla itself.
	 * @param host A {@link URI} which points to the Bugzilla base.
	 * @param httpUser A {@code String} representing an HTTP Basic username.
	 * @param httpPass A {@code String} representing an HTTP Basic password.
	 */
	public abstract void connectTo(URI host, String httpUser, String httpPass) throws ConnectionException;
	
	/**
	 * Retrieves a configured instance of {@link BugRepository} to allow consumers to make queries about
	 * {@link Bug bugs}, create new bugs, or update existing bugs.
	 * @return A {@code BugRepository} implementation provided by the bound SPI provider.
	 */
	public abstract BugRepository getBugRepository();
	
	/**
	 * Retrieves a configured instance of {@link AttachmentRepository} to allow consumers to make queries
	 * about {@link Attachment attachments} or upload new ones.
	 * @return A {@code AttachmentRepository} implementation returned by the bound SPI provider.
	 */
	public abstract AttachmentRepository getAttachmentRepository();
	
	/**
	 * Retrieves a configured instance of {@link CommentRepository} to allow consumers to make queries
	 * about {@link Comment comments} or add new ones.
	 * @return A {@code CommentRepository} implementation returned by the bound SPI provider.
	 */
	public abstract CommentRepository getCommentRepository();
	
	/**
	 * Retrieves a configured instance of {@link ProductRepository} to allow consumers to make queries
	 * about {@link Product products}, update existing or add new ones.
	 * @return A {@code ProductRepository} implementation returned by the bound SPI provider.
	 */
	public abstract ProductRepository getProductRepository();
	
	/**
	 * Retrieves the legal values for the given field.
	 * @param field A {@link GlobalFields field} to look up values for.
	 * @return A {@code Set} of {@code Strings} which can be assigned to the given field.
	 */
	public abstract Set<String> getLegalValuesFor(GlobalFields field);
	
	/**
	 * Gets the version of the remote Bugzilla installation.
	 * @return A {@code String} representing the software version.
	 */
	public abstract String getVersion();
	
	/**
	 * Retrieves the set of products the current user has access to.
	 * @return A {@code Set} of {@link Product} objects.
	 */
	public abstract Set<Product> getAccessibleProducts();
	
	/**
	 * Logs the given user in with the provided credentials. Subsequent requests will be made in the
	 * context of that user's permissions. If called when a user is already logged in, the results are
	 * implementation-specific and considered undefined.
	 * @param user A {@code String} representing a username, typically as an email address.
	 * @param pass A {@code String} representing the user's password.
	 */
	public abstract void logIn(String user, String pass);
	
	/**
	 * Logs the current user out. Subsequent requests will be made anonymously. If called when no user is
	 * logged in, the results are implementation-specific; however, implementations should attempt to ensure
	 * this call is idempotent.
	 */
	public abstract void logOut();
}
