package com.eiericksilva.todolist.exceptions;

import java.time.LocalDate;

public class DataInvalidException extends RuntimeException{
    public DataInvalidException(LocalDate deadline) {
        super("The deadline entered " + deadline + " cannot be before the current moment");
    }
}