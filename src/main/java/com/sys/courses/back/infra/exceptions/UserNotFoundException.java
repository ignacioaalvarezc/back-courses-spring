package com.sys.courses.back.infra.exceptions;

public class UserNotFoundException extends Exception {

    public UserNotFoundException() {
        super("El usuario no se encuentra registrado");
    }

    public UserNotFoundException(String message) {
        super(message);
    }

}
