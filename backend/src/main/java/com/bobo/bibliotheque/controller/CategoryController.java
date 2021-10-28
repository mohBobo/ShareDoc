package com.bobo.bibliotheque.controller;

import com.bobo.bibliotheque.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

public class CategoryController {

    @Autowired
    CategoryRepository categoryRepository;

    @GetMapping("/categories")
    public ResponseEntity listCategories() {
        return new ResponseEntity(categoryRepository.findAll(), HttpStatus.OK);
    }
}
