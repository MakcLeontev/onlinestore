package ru.gb.onlinestore.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.onlinestore.model.Category;
import ru.gb.onlinestore.repository.CategoryRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
public class CategoryService {
    CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category saveCategory(String categoryName) throws IllegalAccessException {
        if (categoryRepository.findByName(categoryName).equals(Optional.empty())){
            Category category = new Category(categoryName);
            categoryRepository.save(category);
            log.info("Категория сохранена");
            return category;
        }else {
            throw new IllegalAccessException("категория с таким именем уже существует");
        }
    }
    public List<Category> findAllCategories(){
        List<Category> categoryList = categoryRepository.findAll().stream().toList();
        if (categoryList != null){
            log.info("список категорий: " + categoryList);
            return categoryList;
        } else {
            throw new NoSuchElementException("категории не найдены");
        }
    }
    public void deleteCategoryById(Long id) throws IllegalAccessException {
        if (categoryRepository.findById(id) == null){
            throw new IllegalAccessException("категория с таким id не существует");
        }
        Category category = categoryRepository.findById(id).get();
        categoryRepository.delete(category);
        log.info("Категория удалена");
    }

}
