package me.hyun.redissample.controller;


import lombok.RequiredArgsConstructor;
import me.hyun.redissample.beans.Product;
import me.hyun.redissample.cache.ProductRepository;
import me.hyun.redissample.service.ProductService;

import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequiredArgsConstructor
public class ProductController {

   private final ProductService productService;

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id){
        Product selectedProduct = productService.getProduct(id);

        return selectedProduct;
    }

}
