package ru.gb.onlinestore.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "OrderProducts")
@NoArgsConstructor
public class OrderProducts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "record_id")
    private Long id;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;
    @Column(name = "product_quantity")
    private Long productQuantity;
}
