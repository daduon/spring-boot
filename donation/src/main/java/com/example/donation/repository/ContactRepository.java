package com.example.donation.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.donation.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact,Long> {
    Optional<Contact> findByTitle(String title);
}
