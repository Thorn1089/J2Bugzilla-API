package com.j2bugzilla.api;

import com.google.common.base.Optional;

/**
 * A {@code Bug} represents a particular item in a Bugzilla installation, commonly depicting a defect in
 * a piece of software, though many teams use reports in Bugzilla for new tasks and other scheduling items.
 * 
 * @author Tom
 */
public final class Bug {

	private final Optional<Integer> id;
	
	public Bug(int id) {
		this.id = Optional.of(id);
	}
	
	public Optional<Integer> getId() {
		return id;
	}
	
}
