package com.projects.shopapp.exceptions;

public class PermissionDenyException extends RuntimeException {

    public PermissionDenyException(String message) {
        super(message);
    }

}
