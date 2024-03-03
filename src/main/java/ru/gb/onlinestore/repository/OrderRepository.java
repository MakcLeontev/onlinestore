package ru.gb.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.onlinestore.model.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order,Long> {
}
