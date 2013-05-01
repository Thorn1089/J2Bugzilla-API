package com.j2bugzilla.api;

import java.util.ServiceLoader;

/**
 * The {@code Bugzilla} class is the entry point into the API. This class adheres to the SPI contract.
 * Implementations should extend it to provide access to the various domain object repositories and
 * methods.
 * 
 * @author Tom
 */
public abstract class Bugzilla {

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
	
}
