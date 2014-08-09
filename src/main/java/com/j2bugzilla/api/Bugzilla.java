package com.j2bugzilla.api;

import java.net.URI;
import java.util.Iterator;
import java.util.ServiceLoader;

import javax.annotation.Nonnull;

/**
 * The {@code Bugzilla} class is the entry point into the API. This class adheres to the SPI contract whereby
 * implementations on the classpath will be loaded automatically, allowing you to compile only against the API
 * interfaces defined within this library. Implementations should extend this class to fill out the various factory methods
 * providing access to a {@link BugzillaConnection}.
 * 
 * Consumers will generally want to use {@link Bugzilla#connectTo(URI)} to connect to a standard Bugzilla installation. The base URI
 * for the site should be provided to allow implementations to decide the mechanism for communicating with the remote API. For example,
 * the default implementation will use XML-RPC, but other implementations may communicate via a RESTful interface instead.
 * 
 * @author Tom
 */
public abstract class Bugzilla {
	
	/**
	 * Connects to the given host without any authentication.
	 * @param host A {@code String} which can be parsed as a URL, pointing to the Bugzilla base.
	 * @return A {@link BugzillaConnection} initialized for the given host.
	 */
	@Nonnull
	public static final BugzillaConnection connectTo(final String host) {
		final Bugzilla instance = getInstance();
		return instance.newSimpleConnection(host);
	}
	
	/**
	 * Connects to the given host.
	 * @param host A {@link URI} which points to the Bugzilla base.
	 * @return A {@link BugzillaConnection} initialized for the given host.
	 */
	@Nonnull
	public static final BugzillaConnection connectTo(final URI host) {
		final Bugzilla instance = getInstance();
		return instance.newSimpleConnection(host);
	}
	
	/**
	 * Connects to the given host, providing credentials via HTTP Basic Auth.
	 * These credentials do not log you into Bugzilla itself.
	 * @param host A {@code String} which can be parsed as a URL, pointing to the Bugzilla base.
	 * @param httpUser A {@code String} representing the HTTP username.
	 * @param httpPass A {@code String} representing the HTTP password.
	 * @return A {@link BugzillaConnection} initialized for the given host and user.
	 */
	@Nonnull
	public static final BugzillaConnection connectTo(final String host, final String httpUser, final String httpPass) {
		final Bugzilla instance = getInstance();
		return instance.newHttpBasicConnection(host, httpUser, httpPass);
	}
	
	/**
	 * Connects to the given host, providing credentials via HTTP Basic Auth.
	 * These credentials do not log you into Bugzilla itself.
	 * @param host A {@link URI} which points to the Bugzilla base.
	 * @param httpUser A {@code String} representing the HTTP username.
	 * @param httpPass A {@code String} representing the HTTP password.
	 * @return A {@link BugzillaConnection} initialized for the given host and user.
	 */
	@Nonnull
	public static final BugzillaConnection connectTo(final URI host, final String httpUser, final String httpPass) {
		final Bugzilla instance = getInstance();
		return instance.newHttpBasicConnection(host, httpUser, httpPass);
	}
	
	@Nonnull
	private static Bugzilla getInstance() {
		final ServiceLoader<Bugzilla> loader = ServiceLoader.load(Bugzilla.class);
		final Iterator<Bugzilla> iterator = loader.iterator();
		if(!iterator.hasNext()) {
			throw new IllegalStateException("No configured providers were found. Please add an implementation to the classpath.");
		}
		final Bugzilla instance = iterator.next();
		assert instance != null : "ServiceLoader should never return a null instance";
		return instance;
	}

	/**
	 * Creates a new {@link BugzillaConnection} pointing to the given URI, represented by a string.
	 * @param uri A {@code String} which can be parsed as a URI.
	 * @return A newly initialized connection.
	 * @throws IllegalArgumentException If the string cannot be parsed as a URI.
	 */
	@Nonnull
	protected abstract BugzillaConnection newSimpleConnection(String uri);
	
	/**
	 * Creates a new {@link BugzillaConnection} pointing to the given URI.
	 * @param uri A {@link URI} which points to a Bugzilla base.
	 * @return A newly initialized connection.
	 */
	@Nonnull
	protected abstract BugzillaConnection newSimpleConnection(URI uri);
	
	/**
	 * Creates a new {@link BugzillaConnection} pointing to the given URI, represented by a string,
	 * which will use HTTP Basic Auth for requests.
	 * @param uri A {@code String} which can be parsed as a URI.
	 * @param user A {@code String} representing the HTTP username.
	 * @param pass A {@code String} representing the HTTP password.
	 * @return A newly initialized connection.
	 * @throws IllegalArgumentException If the string cannot be parsed as a URI.
	 */
	@Nonnull
	protected abstract BugzillaConnection newHttpBasicConnection(String uri, String user, String pass);
	
	/**
	 * Creates a new {@link BugzillaConnection} pointing to the given URI, which will use HTTP Basic Auth
	 * for requests.
	 * @param uri A {@link URI} which points to a Bugzilla base.
	 * @param user A {@code String} representing the HTTP username.
	 * @param pass A {@code String} representing the HTTP password.
	 * @return A newly initialized connection.
	 */
	@Nonnull
	protected abstract BugzillaConnection newHttpBasicConnection(URI uri, String user, String pass);
	
}
