package com.company.exceptions;

public class IllegalAgeException extends Exception{
    @Override
    public String getMessage() {
        return ("Age must be >=18 for voting");
    }
}
