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

import com.example.donation.entity.Category;
import com.example.donation.playload.request.CategoryRequest;
import com.example.donation.repository.CategoryRepository;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public ResponseEntity<List<Category>> listCategories() throws Exception{
        try {
            List<Category> categories = categoryRepository.findAll();
            return new ResponseEntity<>(categories,HttpStatus.OK);
          } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
          }
    }

    @GetMapping("/edit-category/{id}")
    public ResponseEntity<Category> editCategory(@PathVariable(name = "id") Long id) throws Exception{
        Category category = categoryRepository.findById(id).orElseThrow(() -> new Exception("Category id not found: " +id));
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }


    @GetMapping("/detail-category/{id}")
    public ResponseEntity<Category> detailCategory(@PathVariable(name = "id") Long id) throws Exception{
        Category category = categoryRepository.findById(id).orElseThrow(() -> new Exception("Category id not found: " +id));
        return new ResponseEntity<Category>(category, HttpStatus.OK);
    }


    @PostMapping("/create-category")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryRequest request){
        Category category = new Category();
                 category.setTitle(request.getTitle());
                 category.setSubTitle(request.getSubTitle());
                 category.setImage(request.getImage());
                 category.setCreatedAt(new Date(System.currentTimeMillis()));
        return new ResponseEntity<Category>(categoryRepository.save(category), HttpStatus.OK);
    }

    @PutMapping("/update-category/{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable(name = "id") Long id, @RequestBody CategoryRequest request) throws Exception{
        Category category = categoryRepository.findById(id).orElseThrow(() -> new Exception("Category id not found: " + id));
                 category.setTitle(request.getTitle());
                 category.setSubTitle(request.getSubTitle());
                 category.setImage(request.getImage());
                 category.setUpdatedAt(new Date(System.currentTimeMillis()));
        return new ResponseEntity<>(categoryRepository.save(category),HttpStatus.OK);
    }

    @DeleteMapping("/delete-category/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable(name = "id") Long id) throws Exception{
        categoryRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
