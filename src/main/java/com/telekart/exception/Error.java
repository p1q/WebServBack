package com.telekart.exception;

import org.springframework.http.HttpStatus;

class Error {
    private final HttpStatus status;
    private final String message;
    private static final String contact = "mailto:mail@gmail.com?subject=Question";

    Error(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    HttpStatus getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getContact() {
        return contact;
    }
}
