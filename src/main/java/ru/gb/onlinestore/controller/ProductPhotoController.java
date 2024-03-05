package ru.gb.onlinestore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.onlinestore.model.ProductPhoto;
import ru.gb.onlinestore.service.ProductPhotoService;

import java.util.NoSuchElementException;

@CrossOrigin
@RestController
@RequestMapping("/photo")
public class ProductPhotoController {
    private ProductPhotoService productPhotoService;

    public ProductPhotoController(ProductPhotoService productPhotoService) {
        this.productPhotoService = productPhotoService;
    }
    @PostMapping
    public ResponseEntity<ProductPhoto> saveProductPhoto(@RequestBody ProductPhoto productPhoto){
        ProductPhoto productPhoto1 = productPhotoService.saveProductPhoto(productPhoto);
            return ResponseEntity.status(HttpStatus.CREATED).body(productPhoto1);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProductPhoto(@PathVariable Long id){
        try {
            productPhotoService.deleteProductPhoto(id);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductPhoto> updateProductPhoto(@PathVariable Long id, @RequestBody ProductPhoto productPhoto){
        ProductPhoto productPhoto1 = null;
        try {
            productPhoto1 = productPhotoService.updateProductPhoto(id, productPhoto);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(productPhoto1);

    }
}
