package ru.gb.onlinestore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Entity
@Table(name = "subcategory")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Schema(name = "подкатегории")
public class Subcategory{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "subcategory_id")
    @Schema(name = "id")
    private Long id;

    @ManyToOne
    @JoinTable(name = "categorys_subcategories",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "subcategory_id"))
    private Category category;

    @OneToMany(mappedBy = "subcategory")
   // @JoinColumn(name = "product_id")
    private List<Product> products;

    @Column(name = "subcategory_title")
    private String title;

    @Column(name = "subcategory_description")
    private String description;

    @Column(name = "subcategory_show")
    private Boolean subcategoryShow;

    @Column(name = "seo_description")
    private String seoDescription;
//    @Column(name = "seo_keywords")
//    private List<String> seoKeywords;

    @JsonIgnore
    public List<Product> getProducts() {
        return products;
    }

    public Subcategory(String title, Category category) {
        this.category = category;
        this.title = title;
    }

    public Subcategory(String title) {
        this.title = title;
    }
}
