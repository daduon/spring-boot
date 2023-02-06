package com.example.donation.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.donation.entity.About;
import com.example.donation.playload.request.AboutRequest;
import com.example.donation.repository.AboutRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class AboutController {

    @Autowired
    private AboutRepository aboutRepository;

    private final String title = "ABOUT US";
    
    @GetMapping("/list-about")
    public ResponseEntity<About> getAbout() throws Exception{
        About about = aboutRepository.findByTitle(title).orElseThrow(() -> new Exception("Title not found: "+ title));
        return new ResponseEntity<About>(about, HttpStatus.OK);
    }

    @PutMapping("/update-about/{id}")
    public ResponseEntity<About> updateAbout(@PathVariable(name = "id") Long id, @RequestBody AboutRequest request) throws Exception{
        About about = aboutRepository.findById(id).orElseThrow(() -> new Exception("About not found for this id :: " + id));
              about.setTitle(request.getTitle());
              about.setSubTitle(request.getSubTitle());
              about.setDescription(request.getDescription());
              about.setUpdatedAt(new Date(System.currentTimeMillis()));
        return new ResponseEntity<About>(aboutRepository.save(about), HttpStatus.OK);
    }
}
