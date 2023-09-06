package com.eiericksilva.todolist.exceptions;

public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(Long id) {
        super("Resource not Found. Id " + id);
    }
}
