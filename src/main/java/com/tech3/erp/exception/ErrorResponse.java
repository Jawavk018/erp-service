//package com.tech3.erp.exception;
//
//import lombok.*;
//
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//public class ErrorResponse {
//    private String message;
//    private int statusCode;
//}

package com.tech3.erp.exception;

public class ErrorResponse {
    private String message;
    private int statusCode;

    // Constructor with parameters
    public ErrorResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    // Default constructor (optional but recommended)
    public ErrorResponse() {
    }

    // Getters and Setters
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}

