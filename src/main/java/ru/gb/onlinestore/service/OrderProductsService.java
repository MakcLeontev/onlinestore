package ru.gb.onlinestore.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.onlinestore.model.Category;
import ru.gb.onlinestore.model.OrderProducts;
import ru.gb.onlinestore.repository.OrderProductsRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
public class OrderProductsService {
    private final OrderProductsRepository orderProductsRepository;

    public OrderProductsService(OrderProductsRepository orderProductsRepository) {
        this.orderProductsRepository = orderProductsRepository;
    }

    public OrderProducts saveOrderProducts(OrderProducts orderProducts)  {
        OrderProducts saveOrderProducts = null;
        saveOrderProducts = orderProductsRepository.save(orderProducts);
       return saveOrderProducts;
    }
    public List<OrderProducts> findAllOrderProducts(){
        List<OrderProducts> orderProducts = orderProductsRepository.findAll().stream().toList();
        if (orderProducts.isEmpty()){
            throw new NoSuchElementException("не найдены");
        } else {
            return orderProducts;
        }
    }
    public void deleteOrderProductsById(Long id) throws IllegalAccessException {
        Optional<OrderProducts> orderProducts = orderProductsRepository.findById(id);
        if (orderProducts.isEmpty()){
            throw new IllegalAccessException("не существует");
        }
        orderProductsRepository.delete(orderProducts.get());
        log.info("заказ удален");
    }

    public OrderProducts getOrderProductsById(Long id) throws IllegalAccessException {
        Optional<OrderProducts> orderProducts = orderProductsRepository.findById(id);
        if (orderProducts.isEmpty()){
            throw new IllegalAccessException("заказа с таким id не существует");
        }
        return orderProducts.get();
    }
}
