package com.example.donation.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.donation.entity.Post;
import com.example.donation.playload.request.PostRequest;
import com.example.donation.repository.CategoryRepository;
import com.example.donation.repository.PostRepository;
import com.example.donation.repository.UserRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class PostController {

    @Autowired
    private PostRepository postRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/list-post")
    public ResponseEntity<List<Post>> listPost() {
        List<Post> posts = postRepository.findAll();
        return new ResponseEntity<>(posts, HttpStatus.OK);
    }

    @GetMapping("/detail-post/{id}")
    public ResponseEntity<Post> detailPost(@PathVariable(name = "id") Long id) throws Exception {
        Post post = postRepository.findById(id).orElseThrow(() -> new Exception("Post id not found: " + id));
        return new ResponseEntity<>(post, HttpStatus.OK);
    }

    @PostMapping("/user/{userId}/category/{catId}/create-post")
    public ResponseEntity<Post> createPost(@PathVariable(name = "userId") Long userId,@PathVariable(name = "catId") Long catId,
            @RequestBody Post request) throws Exception {

        Post post = new Post();
        post = userRepository.findById(userId).map(user ->{
            user.getPosts().add(request);
            return postRepository.save(request);
        }).orElseThrow(() -> new Exception("Not found user with id = " + userId));
        
        post = categoryRepository.findById(catId).map(cat -> {
            cat.getPosts().add(request);
            request.setCreatedAt(new java.util.Date(System.currentTimeMillis()));
            return postRepository.save(request);
        }).orElseThrow(() -> new Exception("Not found Category with id = " + catId));
        return new ResponseEntity<>(post, HttpStatus.CREATED);
    }

    @PutMapping("/update-post/{id}")
    public ResponseEntity<Post> updatePost(@PathVariable(name = "id") Long id, @RequestBody PostRequest request)
            throws Exception {
        Post post = postRepository.findById(id).orElseThrow(() -> new Exception("Post id not found: " + id));
        post.setTitle(request.getTitle());
        post.setSubTitle(request.getSubTitle());
        post.setImage(request.getImage());
        post.setDescription(request.getDescription());
        post.setVideo(request.getVideo());
        post.setUpdatedAt(new Date(System.currentTimeMillis()));
        return new ResponseEntity<>(postRepository.save(post), HttpStatus.OK);
    }

    @DeleteMapping("/delete-post/{id}")
    public ResponseEntity<Post> deletePost(@PathVariable(name = "id") Long id) throws Exception {
        postRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}