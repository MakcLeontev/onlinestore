package ru.gb.onlinestore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderProducts> orderProducts;

    @Column(name = "creation_date_time")
    private  LocalDateTime creationDateTime;

    @Column(name = "order_sum")
    private BigDecimal sum;

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

    @JsonIgnore
    public List<OrderProducts> getOrderProducts() {
        return orderProducts;
    }

    public Order(User user, BigDecimal sum, String fio, String phone, String address, String comments) {
        this.user = user;
        this.creationDateTime = LocalDateTime.now();;
        this.sum = sum;
        this.fio = fio;
        this.phone = phone;
        this.address = address;
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", user=" + user +
                ", creationDateTime=" + creationDateTime +
                ", sum=" + sum +
                ", fio='" + fio + '\'' +
                ", phone='" + phone + '\'' +
                ", address='" + address + '\'' +
                ", comments='" + comments + '\'' +
                ", orderStatus=" + orderStatus +
                '}';
    }
}
