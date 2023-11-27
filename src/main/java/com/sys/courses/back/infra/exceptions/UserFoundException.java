package com.sys.courses.back.infra.exceptions;

public class UserFoundException extends Exception {

    public UserFoundException() {
        super("El usuario ya esta registrado");
    }

    public UserFoundException(String message) {
        super(message);
    }
}
