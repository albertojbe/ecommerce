package com.albertojbe.simpleecommerce.exceptions;

public class NoProductsPurchased extends RuntimeException{
    public NoProductsPurchased(String message) {
        super(message);
    }
}
