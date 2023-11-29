package com.sys.courses.back.controllers;

import com.sys.courses.back.models.Category;
import com.sys.courses.back.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/categories")
@CrossOrigin("*")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @PostMapping("/")
    public ResponseEntity<Category> saveCategory(@RequestBody Category category) {
        Category savedCategory = categoryService.addCategory(category);
        return ResponseEntity.ok(savedCategory);
    }

    @GetMapping("/{categoryId}")
    public Category listCategoryById(@PathVariable("categoryId") Long categoryId) {
        return categoryService.getCategory(categoryId);
    }

    @GetMapping("/")
    public ResponseEntity<?> listCategories() {
        return ResponseEntity.ok(categoryService.getCategories());
    }

    @PutMapping("/")
    public Category updateCategory(@RequestBody Category category) {
        return categoryService.updateCategory(category);
    }

    @DeleteMapping("/{categoryId}")
    public void deleteCategory(@PathVariable("categoryId") Long categoryId) {
        categoryService.deleteCategory(categoryId);
    }
}
