package com.nhuamani.bankAppApi.exceptions;

public class ModelNotFoundException extends RuntimeException {

    public ModelNotFoundException(String message)
    {
        super(message);
    }
}
