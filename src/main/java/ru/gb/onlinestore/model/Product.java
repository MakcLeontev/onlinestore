package ru.gb.onlinestore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "товары")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "product_id")
    @Schema(name = "id")
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "price")
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private Subcategory subcategory;

    @Column(name = "creation_date_time")
    private LocalDateTime creationDateTime;

    @Column(name = "product_show")
    private Boolean productShow;

    @Column(name = "in_stock")
    private Long inStock;

//    @Column(name = "manufacturer_id")
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;

    @OneToMany(cascade = CascadeType.ALL)
    List<ProductPhoto> productPhotos;

    public Product(String title) {
        this.title = title;
        this.creationDateTime = LocalDateTime.now();
        this.productShow = true;
    }

    public Product(String title, BigDecimal price, Subcategory subcategory, Long inStock, Manufacturer manufacturer) {
        this.title = title;
        this.price = price;
        this.subcategory = subcategory;
        this.creationDateTime = LocalDateTime.now();
        this.productShow = true;
        this.inStock = inStock;
        this.manufacturer = manufacturer;
    }

    @JsonIgnore
    public List<ProductPhoto> getProductPhotos() {
        return productPhotos;
    }

    //    @Column(name = "seo_metatags")
//    private List<String> seoMetatags;

}
