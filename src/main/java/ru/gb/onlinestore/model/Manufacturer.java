package ru.gb.onlinestore.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "manufacturer")
@NoArgsConstructor
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "manufacturer_id")
    private Long id;

    @Column(name = "manufacturer_title")
    private String title;

    @OneToMany(mappedBy = "manufacturer")
    private List<Product> products;

    @JsonIgnore
    public List<Product> getProducts() {
        return products;
    }

    public Manufacturer(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", title='" + title +
                '}';
    }
}
