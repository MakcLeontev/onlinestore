package ru.gb.onlinestore.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.onlinestore.model.Category;
import ru.gb.onlinestore.model.Manufacturer;
import ru.gb.onlinestore.repository.ManufacturerRepository;

import java.util.Optional;

@Slf4j
@Service
public class ManufacturerService {
    private final ManufacturerRepository manufacturerRepository;

    public ManufacturerService(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }
    public Manufacturer saveManufacturer(String title){
        Optional<Manufacturer> manufacturer1 = manufacturerRepository.findByTitle(title);
        if (manufacturer1.isEmpty()){
            Manufacturer manufacturer = new Manufacturer(title);
            manufacturerRepository.save(manufacturer);
            log.info("производитель создан");
            return manufacturer;
        }else {
            throw new IllegalArgumentException("производитель уже существует");
        }
    }
    public Manufacturer getManufacturerById(Long id) throws IllegalAccessException {
        Optional<Manufacturer> manufacturer = manufacturerRepository.findById(id);
        if (manufacturer.isEmpty()){
            throw new IllegalAccessException("производителя с таким id не существует");
        }
        return manufacturer.get();
    }

    public void deleteManufacturerById(Long id) throws IllegalAccessException {
        Optional<Manufacturer> manufacturer = manufacturerRepository.findById(id);
        if (manufacturer.isEmpty()){
            throw new IllegalAccessException("производителя с таким id не существует");
        }else {
            manufacturerRepository.deleteById(id);
        }

    }
}
