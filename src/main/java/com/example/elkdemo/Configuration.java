package com.example.elkdemo;

import com.example.elkdemo.model.Product;
import org.springframework.context.annotation.Bean;
import java.util.Arrays;
import java.util.List;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public List<Product> getProducts(){
        return Arrays.asList(new Product(1,"Samsung"),
                new Product(2,"Iphone"));
    }
}
