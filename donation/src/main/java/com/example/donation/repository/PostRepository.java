package com.example.donation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.donation.entity.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {

}
