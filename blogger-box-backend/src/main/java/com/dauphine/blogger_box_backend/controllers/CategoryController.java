package com.dauphine.blogger_box_backend.controllers;

import com.dauphine.blogger_box_backend.model.Category;
import com.dauphine.blogger_box_backend.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/v1/categories")
public class CategoryController {
    @Autowired
    private final CategoryService service;

    public CategoryController(CategoryService service) {
        this.service = service;
    }


    @GetMapping
    public List<Category> getAllCategories() {
        return this.service.getAll();
    }


    @GetMapping("{id}")
    public Category getCategoryById(@PathVariable UUID id) {
        return this.service.getById(id);
    }

    @PostMapping
    public Category createCategory(@RequestBody String name) {
        return this.service.create(name);
    }

    @PutMapping("{id}")
    public Category updateCategory(@PathVariable UUID id, @RequestBody String name) {
        return service.update(id, name);
    }

    @DeleteMapping ("{id}")
    public boolean deleteCategoryByID(@PathVariable UUID id) {
        return this.service.deleteById(id);
    }

/*Result
  {
    "id": "fce5a5e8-7bbb-400c-a7eb-9a22f5c77e11",
    "name": "my first category"
  },
  {
    "id": "ea170447-a665-4b1b-a8e4-e085bcc3f75e",
    "name": "my second category"
  },
  {
    "id": "b0af3b2e-935e-4de6-ae06-7b3929e53aa6",
    "name": "my third category"
    */




}
