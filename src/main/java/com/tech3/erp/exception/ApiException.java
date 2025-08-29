package com.tech3.erp.exception;

import org.springframework.http.HttpStatus;
import lombok.Getter;


@Getter
public class ApiException extends RuntimeException {
	private static final long serialVersionUID = 1L;

    private final HttpStatus status;

    public ApiException(HttpStatus status, String message) {
        super(message); // Call the RuntimeException constructor
        this.status = status;
    }
    
 // Explicitly define the getter method
    public HttpStatus getStatus() {
        return status;
    }
}
