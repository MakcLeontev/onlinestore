package ru.gb.onlinestore.service;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.onlinestore.model.Product;
import ru.gb.onlinestore.repository.ProductRepository;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Slf4j
@Service
public class ProductService {
    ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Product saveProduct(Product product){
        productRepository.save(product);
        log.info(product + " товар сохранен");
        return product;
    }

    public void deleteProduct(Long id){
        Product product = productRepository.findById(id).get();
        if (product!=null){
            productRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("Не найден товар с id: " + id);
        }
        log.info("товар удален, id = " + id);
    }
    public Product updateProduct(Long id, Product product){
        Product productForUpdate = productRepository.findById(id).get();
        if (productForUpdate!=null){
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
        Product product = productRepository.findById(id).get();
        if (product!=null){
            return product;
        } else {
            throw new NoSuchElementException("Не найден товар с id: " + id);
        }
    }
    public List<Product> findAll(){
        List<Product> products = productRepository.findAll();
        if (products!= null){
            return products;
        } else {
            throw new NoSuchElementException("товары не найдены");
        }
    }
}
