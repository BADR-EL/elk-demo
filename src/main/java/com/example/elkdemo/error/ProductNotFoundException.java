package com.example.elkdemo.error;


public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message){super(message);}

}
