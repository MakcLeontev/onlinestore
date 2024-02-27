package ru.gb.onlinestore.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.onlinestore.model.Category;
import ru.gb.onlinestore.model.Subcategory;
import ru.gb.onlinestore.repository.SubcategoryRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
public class SubcategoryService {
    private final SubcategoryRepository subcategoryRepository;
    public SubcategoryService(SubcategoryRepository subcategoryRepository) {
        this.subcategoryRepository = subcategoryRepository;
    }

    public Subcategory saveSubcategory(String subCategoryName) throws IllegalArgumentException {
        if (subcategoryRepository.findByTitle(subCategoryName).isEmpty()){
            Subcategory subcategory = new Subcategory(subCategoryName);
            subcategoryRepository.save(subcategory);
            log.info("Категория сохранена");
            return subcategory;
        }else {
            throw new IllegalArgumentException("категория с таким именем уже существует");
        }
    }
    public List<Subcategory> findAllSubcategorys(){
        List<Subcategory> categoryList = subcategoryRepository.findAll().stream().toList();
        if (categoryList.isEmpty()){
            throw new NoSuchElementException("категории не найдены");
        } else {
            log.info("список категорий: " + categoryList);
            return categoryList;
        }
    }
    public void deleteSubcategoryById(Long id) throws IllegalAccessException {
        Optional<Subcategory> category = subcategoryRepository.findById(id);
        if (category.isEmpty()){
            throw new IllegalAccessException("категория с таким id не существует");
        }
        subcategoryRepository.delete(category.get());
        log.info("Категория удалена");
    }

    public Subcategory getSubcategoryById(Long id) throws IllegalAccessException {
        Optional<Subcategory> category = subcategoryRepository.findById(id);
        if (category.isEmpty()){
            throw new IllegalAccessException("категория с таким id не существует");
        }
        return category.get();
    }
}
