package com.example.springcrud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.springcrud.entity.Product;
import com.example.springcrud.service.ProductServiceImpl;

@RestController
public class ProductController {
    @Autowired
    private ProductServiceImpl productServiceImpl;

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return productServiceImpl.listProdcts();
    }

    @PostMapping("/save/product")
    public Product saveProduct(@RequestBody Product product){
        return productServiceImpl.saveProduct(product);
    }

    @PutMapping("/update/product/{id}")
    public Product updateProduct(@PathVariable(name = "id") Long id, @RequestBody Product product){
        return productServiceImpl.updateProduct(product, id);
    }

    @DeleteMapping("/delete/product/{id}")
    public String deleteProduct(@PathVariable(name = "id") Long id){
        productServiceImpl.deleteProduct(id);
        return "Deleted Successfully " + id;
    }
    
}
