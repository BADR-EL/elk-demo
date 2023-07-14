package com.example.elkdemo.error;

import lombok.AllArgsConstructor;
import java.util.function.Supplier;

@AllArgsConstructor
public class ProductNotFoundSupplier implements Supplier<ProductNotFoundException> {
    private String message;
    @Override
    public ProductNotFoundException get() {
        return new ProductNotFoundException(message);
    }
}
