package com.myprojects.ebankingbackend.exceptions;
//exception surveillée: method use throws or try catch
//exception non surveillée: !(method use throws) : extends RuntimeException
public class CustomerNotFoundException extends Exception {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
