package com.example.springMVC;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {

    @GetMapping("/api/products")
    public List<Product> getProducts() {
        Product iPhone = new Product("Iphone");
        Product appleWatch = new Product("Apple Watch");
        Product appleTv = new Product("Apple TV");

        return List.of(iPhone, appleWatch, appleTv);
    }

}

class Product {
    private String id = UUID.randomUUID().toString();
    @JsonProperty("product_name")
    private String name;

    public Product(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
}
