package com.example.elkdemo;

import com.example.elkdemo.error.ProductNotFoundSupplier;
import com.example.elkdemo.model.Product;
import com.example.elkdemo.model.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import java.util.List;
import java.util.Optional;

@Controller
@Slf4j
public class ProductController {

    @Autowired
    List<Product> products;

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getPruduct(@PathVariable int id) throws RuntimeException{
        Optional<Product> optionalProduct = products.stream()
                .filter(p-> p.getId()==id)
                .findAny();
        Product product = optionalProduct.orElseThrow(new ProductNotFoundSupplier("Product "+id+" not found"));
        log.info("return product with id = "+id+" successfully");
        return new ResponseEntity<>(new Response("ok",product), HttpStatus.OK);
    }
}
