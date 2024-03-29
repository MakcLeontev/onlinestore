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
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "category_id")
    private Category category;

    @OneToMany(mappedBy = "subcategory")
    private List<Product> products;

    @Column(name = "subcategory_title")
    private String title;

    @Column(name = "subcategory_description")
    private String description;

    @Column(name = "subcategory_show")
    private Boolean subcategoryShow;

    @JsonIgnore
    public List<Product> getProducts() {
        return products;
    }


    public Subcategory(String title, Category category) {
        this.category = category;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Subcategory{" +
                "id=" + id +
                ", category=" + category +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", subcategoryShow=" + subcategoryShow +
                '}';
    }
}
