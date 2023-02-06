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

import com.example.donation.entity.Contact;
import com.example.donation.playload.request.ContactRequest;
import com.example.donation.repository.ContactRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class ContactController {

    @Autowired
    private ContactRepository contactRepository;

    private final String title = "CONTACT US";

    @GetMapping("/list-contact")
    public ResponseEntity<Contact> getContact() throws Exception{
        Contact contact = contactRepository.findByTitle(title).orElseThrow(() -> new Exception("Title not found " + title));
        return new ResponseEntity<Contact>(contact, HttpStatus.OK);
    }

    @PutMapping("/update-contact/{id}")
    public ResponseEntity<Contact> updateContact(@PathVariable(name = "id") Long id, @RequestBody ContactRequest request) throws Exception {
        Contact contact = contactRepository.findById(id).orElseThrow(() -> new Exception("Contact id not found: " + id));
                contact.setTitle(request.getTitle());
                contact.setEmail(request.getEmail());
                contact.setNumber(request.getNumber());
                contact.setLocation(request.getLocation());
                contact.setUpdatedAt(new Date(System.currentTimeMillis()));
        return new ResponseEntity<Contact>(contactRepository.save(contact), HttpStatus.OK);
    }
}
