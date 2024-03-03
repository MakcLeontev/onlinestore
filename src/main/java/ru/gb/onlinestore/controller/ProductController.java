package ru.gb.onlinestore.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.onlinestore.model.Product;
import ru.gb.onlinestore.service.ProductService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;
@CrossOrigin
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    ProductService productService;

    @GetMapping("/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable Long id){
        Product product = null;
        try {
            product = productService.findById(id);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
    @GetMapping("/all")
    public ResponseEntity<List<Product>> findAll(){
        List<Product> products = null;
        try {
            products = productService.findAll();
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(products);
    }
    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestBody Product product){
        product.setCreationDateTime(LocalDateTime.now());
        Product saveProduct = null;
        saveProduct = productService.saveProduct(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(saveProduct);
    }
//    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id){
        try {
            productService.deleteProduct(id);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestBody Product product){
        Product product1 = null;
        try {
            product1 = productService.updateProduct(id,product);
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(product1);
    }

}
