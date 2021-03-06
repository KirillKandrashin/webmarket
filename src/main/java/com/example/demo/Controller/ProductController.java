package com.example.demo.Controller;

import com.example.demo.Entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.demo.Service.ProductService;

import java.util.List;

public class ProductController {
    private ProductService productService;

    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping(value = "/product")
    public ResponseEntity<?> create(@RequestBody Product product){
        productService.create(product);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping(value = "/product")
    public ResponseEntity<List<Product>> findAll(){
        final List<Product> productList = productService.findAll();

        return productList != null && !productList.isEmpty()
                ? new ResponseEntity<>(productList, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping(value = "/product/{id}")
    public ResponseEntity<Product> find(@PathVariable(name="id") Long id){
        final Product product = productService.find(id);

        return product != null
                ? new ResponseEntity<>(product, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(value = "/product")
    public ResponseEntity<?> deleteById(@PathVariable(name="id") Long id){
        productService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}