package com.example.springcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springcrud.entity.Product;

public interface ProductRepository extends JpaRepository<Product,Long> {
    
}
