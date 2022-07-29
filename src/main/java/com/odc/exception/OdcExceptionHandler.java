package com.odc.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice // It allows us to handle exceptions across the whole application, not just to
					// an individual controller.
public class OdcExceptionHandler {

	@ExceptionHandler
	public ResponseEntity<String> handleException(DeletionException pnf) {
		return new ResponseEntity<String>(pnf.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler // used to handle the specific exceptions and sending the custom responses to
						// the client.
	public ResponseEntity<String> handleException(CreationException pnf) {
		return new ResponseEntity<String>(pnf.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<String> handleException(EmptyListException pnf) {
		// ResponseEntity represents the whole HTTP response: status code, headers, and
		// body. As a result, we can use it to fully configure the HTTP response.
		return new ResponseEntity<String>(pnf.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<String> handleException(EntityNotFoundException pnf) {
		return new ResponseEntity<String>(pnf.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler
	public ResponseEntity<String> handleException(UpdationException pnf) {
		return new ResponseEntity<String>(pnf.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> handleException(UserNotFoundException pnf) {
		return new ResponseEntity<String>(pnf.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<String> handleException(PasswordMismatchException pnf) {
		return new ResponseEntity<String>(pnf.getMessage(), HttpStatus.NOT_FOUND);
	}
	
}
