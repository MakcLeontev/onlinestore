package ru.gb.onlinestore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.onlinestore.model.Subcategory;
import ru.gb.onlinestore.service.SubcategoryService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/subcategory")
public class SubcategoryController {
    private SubcategoryService subcategoryService;

    public SubcategoryController(SubcategoryService subcategoryService) {
        this.subcategoryService = subcategoryService;
    }

    @PostMapping
    public ResponseEntity<Subcategory> saveSubcategory(@RequestBody Subcategory subcategory){
        Subcategory subcategory1 = null;
        try {
            subcategory1 = subcategoryService.saveSubcategory(subcategory.getTitle());
        } catch (IllegalArgumentException e) {
           return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(subcategory1);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Subcategory>> findAllSubcategorys(){
        List<Subcategory> subcategoryList = null;
        try {
            subcategoryList = subcategoryService.findAllSubcategorys();
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(subcategoryList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteSubcategoryById(@PathVariable Long id){
        try {
            subcategoryService.deleteSubcategoryById(id);
        } catch (IllegalAccessException e) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Subcategory> getSubcategoryById(@PathVariable Long id){
        Subcategory subcategory = null;
        try {
            subcategory = subcategoryService.getSubcategoryById(id);
        } catch (IllegalAccessException e) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(subcategory);
    }
}
