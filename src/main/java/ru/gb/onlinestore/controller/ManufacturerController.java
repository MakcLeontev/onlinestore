package ru.gb.onlinestore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.onlinestore.model.Category;
import ru.gb.onlinestore.model.Manufacturer;
import ru.gb.onlinestore.service.ManufacturerService;

import java.util.List;
import java.util.NoSuchElementException;
@CrossOrigin
@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController {
    private ManufacturerService manufacturerService;

    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }

    @PostMapping
    public ResponseEntity<Manufacturer> saveManufacturer(@RequestBody Manufacturer manufacturer){
        Manufacturer manufacturer1 = null;
        try {
            manufacturer1 = manufacturerService.saveManufacturer(manufacturer.getTitle());
        } catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(manufacturer1);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Manufacturer> getManufacturerById(@PathVariable Long id){
        Manufacturer manufacturer = null;
        try {
            manufacturer = manufacturerService.getManufacturerById(id);
        } catch (IllegalAccessException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(manufacturer);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Manufacturer>> findAll(){
        List<Manufacturer> manufacturerList = null;
        try {
            manufacturerList = manufacturerService.getAllManufacturer();
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(manufacturerList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteManufacturerById(@PathVariable Long id){
        try {
            manufacturerService.deleteManufacturerById(id);
        } catch (IllegalAccessException e) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }

}
