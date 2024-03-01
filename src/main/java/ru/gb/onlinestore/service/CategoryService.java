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
    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public void saveToDB(){
        categoryRepository.save(new Category("Светильники и комплектующие"));
        categoryRepository.save(new Category("Источники света"));
        categoryRepository.save(new Category("Кабельно-проводниковая продукция"));
        categoryRepository.save(new Category("Системы для прокладки кабеля и монтажа"));
        categoryRepository.save(new Category("Низковольтное оборудование"));
        categoryRepository.save(new Category("Счетчики"));
        categoryRepository.save(new Category("Шкафы, боксы и принадлежности"));
        categoryRepository.save(new Category("Электроустановочные изделия"));
        categoryRepository.save(new Category("Удлинители, катушки"));
        categoryRepository.save(new Category("Элементы питания"));
        categoryRepository.save(new Category("Телекоммуникационный кабель и комплектующие"));
        categoryRepository.save(new Category("Инструменты и расходные материалы"));

    }

    public Category saveCategory(String categoryName) throws IllegalAccessException {
        if (categoryRepository.findByTitle(categoryName).isEmpty()){
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

    public Category getCategoryById(Long id) throws IllegalAccessException {
        Optional<Category> category = categoryRepository.findById(id);
        if (category.isEmpty()){
            throw new IllegalAccessException("категория с таким id не существует");
        }
        return category.get();
    }

}
