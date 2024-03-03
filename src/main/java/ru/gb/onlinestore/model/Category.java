package ru.gb.onlinestore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "categories")
@NoArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "category_id")
    private Long id;

    @Column(name = "category_title")
    private String title;

    @OneToMany(mappedBy = "category")
    private List<Subcategory> subcategories;

    @Column(name = "category_description")
    private String description;

    @Column(name = "category_show")
    private Boolean categoryShow;

    @Column(name = "seo_description")
    private String seoDescription;
//    @Column(name = "seo_keywords")
//    private List<String> seoKeywords;

    public Category(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public Category(String title) {
        this.title = title;
    }

    @JsonIgnore
    public List<Subcategory> getSubcategories() {
        return subcategories;
    }




    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", title='" + title + '\'' +
                '}';
    }
}
