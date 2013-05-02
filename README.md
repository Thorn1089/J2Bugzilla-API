J2Bugzilla-API
==============

The J2Bugzilla API project defines a facade layer for J2Bugzilla 3.0, similar in style to projects like slf4j. It allows consumers to compile against a standard API and bind to a specific implementation by providing an appropriate JAR on the classpath at runtime. j2bugzilla-api uses the Service Provider Interface to dynamically load an implementation which fulfills the API specification.

To use the API in your code, you must first obtain a reference to the Bugzilla object. This is available through a static factory method in the class which performs the dynamic service lookup, like so:

Bugzilla bugzilla = Bugzilla.newBugzilla();

Users may then connect to an installation by providing the URL, as well as optional credentials for HTTP Basic authentication. At this point, bugs can be queried, created, or updated by using one of the repository interfaces. Additionally, metadata about the installation can be retrieved from the Bugzilla object itself, such as the software version, legal field values, and available products. User authentication is also performed via the Bugzilla object.
