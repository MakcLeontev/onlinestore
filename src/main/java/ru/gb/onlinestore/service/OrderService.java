package ru.gb.onlinestore.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.onlinestore.model.Order;
import ru.gb.onlinestore.repository.OrderRepository;

import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveOrder(Order order){
        Order saveOrder = null;
        saveOrder = orderRepository.save(order);
        return saveOrder;
    }

    public Order updateOrder(Long id, Order order) throws NoSuchElementException{
        if (orderRepository.findById(id).isPresent()){
            Order updateOrder = order;
            updateOrder.setId(id);
            orderRepository.save(updateOrder);
            log.info("заказ успешно обновлен");
            return updateOrder;
        }else {
            throw new NoSuchElementException("заказа не существует");
        }
    }

    public void deleteOrder(Long id) throws NoSuchElementException{
        if (orderRepository.findById(id).isPresent()){
            orderRepository.deleteById(id);
            log.info("заказ успешно удален");
        }else {
            throw new NoSuchElementException("заказа не существует");
        }
    }

    public Order getOrderById(Long id) throws NoSuchElementException{
        Optional<Order> findOrder = orderRepository.findById(id);
        if (findOrder.isPresent()){
            log.info("заказ выдан");
            return findOrder.get();
        }else {
            throw new NoSuchElementException("заказа не существует");
        }
    }
}
