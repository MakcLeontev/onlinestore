package ru.gb.onlinestore.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.onlinestore.model.ProductPhoto;
import ru.gb.onlinestore.repository.ProductPhotoRepository;

import java.util.NoSuchElementException;

@Service
@Slf4j
public class ProductPhotoService {
    private final ProductPhotoRepository productPhotoRepository;

    public ProductPhotoService(ProductPhotoRepository productPhotoRepository) {
        this.productPhotoRepository = productPhotoRepository;
    }

    public ProductPhoto saveProductPhoto(ProductPhoto productPhoto){
        productPhotoRepository.save(productPhoto);
        log.info("фото сохранено");
        return productPhoto;
    }
    public void deleteProductPhoto(Long id) throws NoSuchElementException{
        if (productPhotoRepository.findById(id).isPresent()){
            productPhotoRepository.deleteById(id);
        } else {
            throw new NoSuchElementException("фото с таким id не существует");
        }
        log.info("фото удалено id: " + id);
    }
    public ProductPhoto updateProductPhoto(Long id, ProductPhoto productPhoto) throws NoSuchElementException{
        ProductPhoto productPhoto1 = null;
        if (productPhotoRepository.findById(id).isPresent()){
            productPhoto1 = productPhoto;
            productPhoto1.setId(id);
            productPhotoRepository.save(productPhoto1);
            log.info("фото обновлено id: " + id);
            return productPhoto1;
        } else {
            throw new NoSuchElementException("фото с таким id не существует");
        }
    }
}
