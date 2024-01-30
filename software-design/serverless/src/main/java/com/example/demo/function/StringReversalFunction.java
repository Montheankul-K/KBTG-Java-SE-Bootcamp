package com.example.demo.function;

import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class StringReversalFunction implements Function<String, String> {
    @Override
    public String apply(String value) {
        String reversal = new StringBuilder(value).reverse().toString();
        System.out.println(reversal);
        return reversal;
    }
}
