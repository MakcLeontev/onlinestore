package ru.gb.onlinestore.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "orders")
@Data
@NoArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "users_orders",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private User user;

    @ManyToMany
    @JoinTable(name = "orders_order_products",
            joinColumns = @JoinColumn(name = "order_id"),
            inverseJoinColumns = @JoinColumn(name = "record_id"))
    private List<OrderProducts> orderProducts;

    @Column(name = "creation_date_time")
    private  LocalDateTime creationDateTime;

    @Column(name = "order_sum")
    private BigDecimal summ;

    @Column(name = "order_fio")
    private String fio;

    @Column(name = "order_phone")
    private String phone;

    @Column(name = "order_delivery_adress")
    private String address;

    @Column(name = "order_delivery_comments")
    private String comments;

    @Enumerated(EnumType.STRING)
    @Column(name = "order_status")
    private OrderStatus orderStatus;

}
