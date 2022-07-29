package com.odc.exception;

public class DeletionException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public DeletionException(String message) {
		super(message);
	}
}
