package ru.gb.onlinestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.gb.onlinestore.model.Category;
import ru.gb.onlinestore.model.Subcategory;

import java.util.Optional;

@Repository
public interface SubcategoryRepository extends JpaRepository<Subcategory,Long> {
    Optional<Subcategory> findByTitle(String title);
    Optional<Subcategory> findById(Long id);
}
