package com.example.depomanagementservlet.exception;

import java.util.Objects;

public class CustomNotFoundException extends RuntimeException {


    public CustomNotFoundException() {
    }

    public CustomNotFoundException(String message) {
        super(message);
    }

    public CustomNotFoundException(Class aClass, Object id) {
        super(aClass.getSimpleName() + " not found with id: " + id);
    }


}
