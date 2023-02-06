package com.example.donation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.donation.entity.About;

@Repository
public interface AboutRepository extends JpaRepository<About,Long> {
    Optional<About> findByTitle(String title);
}
