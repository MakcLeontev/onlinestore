package ru.gb.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.onlinestore.model.OrderProducts;

@Repository
public interface OrderProductsRepository extends JpaRepository<OrderProducts,Long> {
}
