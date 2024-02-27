package ru.gb.onlinestore.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "product_photo")
@NoArgsConstructor
@AllArgsConstructor
public class ProductPhoto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "photo_id")
    @Schema(name = "id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "product_id")
    Product product;
    @Column(name = "photo_link")
    String photoLink;
    @Column(name = "photo_is_main")
    Boolean photoIsMain;

    public ProductPhoto(Product product, String photoLink, Boolean photoIsMain) {
        this.product = product;
        this.photoLink = photoLink;
        this.photoIsMain = photoIsMain;
    }
}
