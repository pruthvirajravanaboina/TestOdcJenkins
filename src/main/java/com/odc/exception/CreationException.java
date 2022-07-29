package com.odc.exception;

public class CreationException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	// The serialVersionUID is a universal version identifier for a Serializable
	// class.
	// Deserialization uses this number to ensure that a loaded class corresponds
	// exactly to a serialized object.
	// If no match is found, then an InvalidClassException is thrown.
	public CreationException(String message) {
		super(message); // is a reference variable which is used to refer immediate parent class object.

	}
}
