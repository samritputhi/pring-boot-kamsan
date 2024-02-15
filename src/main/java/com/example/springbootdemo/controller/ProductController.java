package com.example.springbootdemo.controller;

import com.example.springbootdemo.model.ProductModel;
import com.example.springbootdemo.repository.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService repository;

    public ProductController(ProductService repository) {
        this.repository = repository;
    }

    @GetMapping("/product")
    public List<ProductModel> getAllProduct() {
      return  repository.findAll();
    }

    @GetMapping("/product/{id}")
    ProductModel one(@PathVariable Long id) {

        return repository.findById(id).orElseThrow(() -> new ResponseStatusException(
                HttpStatus.NOT_FOUND, "entity not found"
        ));
    }

    @PostMapping("/product")
    ProductModel createProduct(@RequestBody ProductModel product) {
        return repository.save(product);
    }

    @PutMapping("/product/{id}")
    ProductModel updateProduct(@RequestBody ProductModel newProduct, @PathVariable Long id) {

        return repository.findById(id)
                .map(product -> {
                    product.setName(newProduct.getName());
                    product.setDescription(newProduct.getDescription());
                    return repository.save(product);
                })
                .orElseGet(() -> {
                    newProduct.setId(id);
                    return repository.save(newProduct);
                });
    }

    @DeleteMapping("/product/{id}")
    void deleteProduct(@PathVariable Long id) {
        repository.deleteById(id);
    }

}