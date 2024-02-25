package ru.gb.onlinestore.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.onlinestore.model.Category;
import ru.gb.onlinestore.model.Product;
import ru.gb.onlinestore.repository.CategoryRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
public class CategoryService {
    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category saveCategory(String categoryName) throws IllegalAccessException {
        if (categoryRepository.findByName(categoryName).isEmpty()){
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
        if (categoryList.isEmpty()){
            throw new NoSuchElementException("категории не найдены");
        } else {
            log.info("список категорий: " + categoryList);
            return categoryList;
        }
    }
    public void deleteCategoryById(Long id) throws IllegalAccessException {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()){
            throw new IllegalAccessException("категория с таким id не существует");
        }
        categoryRepository.delete(category.get());
        log.info("Категория удалена");
    }
    public List<Product> getProducts(Long id){
        Category category = categoryRepository.findById(id).get();
        List<Product> products = category.getProducts();
        return products;
    }
    public Category getCategoryById(Long id) throws IllegalAccessException {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()){
            throw new IllegalAccessException("категория с таким id не существует");
        }
        return category.get();
    }

}
