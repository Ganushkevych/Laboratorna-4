package com.example.exceptions;

public class WrongValueException extends RuntimeException{
    public WrongValueException(String message){
        super(message);
    }

}
