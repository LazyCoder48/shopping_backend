package com.shop.exception;

public class ProductNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 3872397644928745813L;

    public ProductNotFoundException(String message) {
        super(message);
    }

}
