package ru.gb.onlinestore.service;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.onlinestore.model.Category;
import ru.gb.onlinestore.model.Product;
import ru.gb.onlinestore.repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
public class ProductService {
    private ProductRepository productRepository;
    private CategoryService categoryService;

    public ProductService(ProductRepository productRepository, CategoryService categoryService) {
        this.productRepository = productRepository;
        this.categoryService = categoryService;
    }

    public Product saveProduct(Product product) throws IllegalAccessException {
        productRepository.save(product);
        Long id = product.getCategory().getId();
        Category category = categoryService.getCategoryById(id);
        List<Product> products = category.getProducts();
        products.add(product);
        category.setProducts(products);
        log.info(product + " товар сохранен");
        return product;
    }

    public void deleteProduct(Long id){
        if (productRepository.findById(id).isPresent()){
            productRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Не найден товар с id: " + id);
        }
        log.info("товар удален, id = " + id);
    }
    public Product updateProduct(Long id, Product product){
        Product productForUpdate = null;
        if (productRepository.findById(id).isPresent()){
            productForUpdate = product;
            productForUpdate.setId(id);
            productRepository.save(productForUpdate);
            log.info("товар обновлен, id: " + id);
            return productForUpdate;
        } else {
            throw new NoSuchElementException("Не найден товар с id: " + id);
        }
    }
    public Product findById(Long id){
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()){
            return product.get();
        } else {
            throw new NoSuchElementException("Не найден товар с id: " + id);
        }
    }
    public List<Product> findAll(){
        List<Product> products = productRepository.findAll();
        if (products.isEmpty()){
            throw new NoSuchElementException("товары не найдены");
        } else {
            return products;
        }
    }
}
