package ru.gb.onlinestore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.onlinestore.model.OrderProducts;
import ru.gb.onlinestore.model.Subcategory;
import ru.gb.onlinestore.service.OrderProductsService;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/orderproduct")
public class OrderProductController {
    private OrderProductsService orderProductsService;

    public OrderProductController(OrderProductsService orderProductsService) {
        this.orderProductsService = orderProductsService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<OrderProducts>> findAllOrderProducts(){
        List<OrderProducts> orderProductsList = null;
        try {
            orderProductsList = orderProductsService.findAllOrderProducts();
        } catch (NoSuchElementException e){
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(orderProductsList);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteOrderProductsById(@PathVariable Long id){
        try {
            orderProductsService.deleteOrderProductsById(id);
        } catch (IllegalAccessException e) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/{id}")
    public ResponseEntity<OrderProducts> getOrderProductsById(@PathVariable Long id){
        OrderProducts orderProducts = null;
        try {
            orderProducts = orderProductsService.getOrderProductsById(id);
        } catch (IllegalAccessException e) {
            ResponseEntity.notFound().build();
        }
        return ResponseEntity.status(HttpStatus.OK).body(orderProducts);
    }
}
