package com.example.donation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.donation.entity.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
    
}
