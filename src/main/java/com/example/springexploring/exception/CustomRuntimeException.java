package com.example.springexploring.exception;


public class CustomRuntimeException extends RuntimeException {
    public CustomRuntimeException(){
        super();
    }

    public CustomRuntimeException(String message){
        super(message);
    }

}
