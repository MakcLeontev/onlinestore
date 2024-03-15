package ru.gb.onlinestore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "OrderProducts")
@NoArgsConstructor
public class OrderProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;

    @Column(name = "product_quantity")
    private Long productQuantity;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "order_id")
    private Order order;

//    @JsonIgnore
//    public List<Order> getOrders() {
//        return orders;
//    }


    @Override
    public String toString() {
        return "OrderProducts{" +
                "id=" + id +
                ", product=" + product +
                ", productQuantity=" + productQuantity +
                ", order=" + order +
                '}';
    }

    public OrderProducts(Product product, Long productQuantity) {
        this.product = product;
        this.productQuantity = productQuantity;
    }

    public OrderProducts(Product product, Long productQuantity, Order order) {
        this.product = product;
        this.productQuantity = productQuantity;
        this.order = order;
    }
}
