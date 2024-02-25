package ru.gb.onlinestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.onlinestore.model.Category;
import ru.gb.onlinestore.model.Product;
import ru.gb.onlinestore.service.CategoryService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    CategoryService categoryService;

    @GetMapping("/all")
    public ResponseEntity<List<Category>> findAll(){
        List<Category> categoryList = null;
        try {
            categoryList = categoryService.findAllCategories();
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(categoryList);
    }
    @PostMapping
    public ResponseEntity<Category> saveCategory(@RequestBody Category category){
        Category category1 = null;
       try {
           category1 = categoryService.saveCategory(category.getName());
       } catch (IllegalAccessException e) {
           ResponseEntity.badRequest().build();
       }
       return ResponseEntity.status(HttpStatus.CREATED).body(category1);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteCategory(@PathVariable Long id){
        try {
            categoryService.deleteCategoryById(id);
        } catch (IllegalAccessException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/product/{id}")
    public ResponseEntity<List<Product>> getProduct(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(categoryService.getProducts(id));
    }
}
