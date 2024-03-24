package ru.gb.onlinestore.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.gb.onlinestore.model.Category;
import ru.gb.onlinestore.model.Manufacturer;
import ru.gb.onlinestore.model.Product;
import ru.gb.onlinestore.model.Subcategory;
import ru.gb.onlinestore.repository.CategoryRepository;
import ru.gb.onlinestore.repository.ManufacturerRepository;
import ru.gb.onlinestore.repository.ProductRepository;
import ru.gb.onlinestore.repository.SubcategoryRepository;

import java.math.BigDecimal;

@Slf4j
@Service
// данный класс нужен только для заполнения данными
public class SaveService {
    private CategoryRepository categoryRepository;
    private CategoryService categoryService;
    private SubcategoryRepository subcategoryRepository;
    private ManufacturerRepository manufacturerRepository;
    private ProductRepository productRepository;
    private SubcategoryService subcategoryService;
    private ManufacturerService manufacturerService;

    public SaveService(CategoryRepository categoryRepository, CategoryService categoryService, SubcategoryRepository subcategoryRepository, ManufacturerRepository manufacturerRepository, ProductRepository productRepository, SubcategoryService subcategoryService, ManufacturerService manufacturerService) {
        this.categoryRepository = categoryRepository;
        this.categoryService = categoryService;
        this.subcategoryRepository = subcategoryRepository;
        this.manufacturerRepository = manufacturerRepository;
        this.productRepository = productRepository;
        this.subcategoryService = subcategoryService;
        this.manufacturerService = manufacturerService;
        saveToDb();
    }

    public void saveToDb(){
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
        manufacturerRepository.save(new Manufacturer("Rexant"));
        manufacturerRepository.save(new Manufacturer("Tango"));

        try {
            subcategoryRepository.save(new Subcategory("Светильники светодиодные", categoryService.getCategoryById(1L)));
            subcategoryRepository.save(new Subcategory("Светильники уличные", categoryService.getCategoryById(1L)));
            subcategoryRepository.save(new Subcategory("Светильники настольные", categoryService.getCategoryById(1L)));
            subcategoryRepository.save(new Subcategory("Лампы светодиодные", categoryService.getCategoryById(2L)));
            subcategoryRepository.save(new Subcategory("Лампы накаливания", categoryService.getCategoryById(2L)));
            subcategoryRepository.save(new Subcategory("Лампы люминесцентные", categoryService.getCategoryById(2L)));
            subcategoryRepository.save(new Subcategory("ГОСТ", categoryService.getCategoryById(3L)));
            subcategoryRepository.save(new Subcategory("ТУ", categoryService.getCategoryById(3L)));
            subcategoryRepository.save(new Subcategory("Коробки монтажные", categoryService.getCategoryById(4L)));
            subcategoryRepository.save(new Subcategory("Магистральные кабель-каналы", categoryService.getCategoryById(4L)));
            subcategoryRepository.save(new Subcategory("Автоматические выключатели", categoryService.getCategoryById(5L)));
            subcategoryRepository.save(new Subcategory("Пластиковые корпуса", categoryService.getCategoryById(7L)));
            subcategoryRepository.save(new Subcategory("Щитки металлические модульные", categoryService.getCategoryById(7L)));
            subcategoryRepository.save(new Subcategory("Счетчики однофазные", categoryService.getCategoryById(6L)));
            subcategoryRepository.save(new Subcategory("Счетчики трехфазные", categoryService.getCategoryById(6L)));
            subcategoryRepository.save(new Subcategory("Звонки", categoryService.getCategoryById(8L)));
            subcategoryRepository.save(new Subcategory("Аксессуары", categoryService.getCategoryById(8L)));
            subcategoryRepository.save(new Subcategory("Удлинители силовые", categoryService.getCategoryById(9L)));
            subcategoryRepository.save(new Subcategory("Удлинители бытовые", categoryService.getCategoryById(9L)));
        }catch (IllegalAccessException e){
            log.info("ошибка создания подкатегории");
        }
        try {
            productRepository.save(new Product("Светильник 20вт", new BigDecimal(456), subcategoryService.getSubcategoryById(1L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/premium-photo/3d-rendering-pendant-lamp-isolated-on-white_493806-8663.jpg?w=826"));
            productRepository.save(new Product("Светильник 60вт", new BigDecimal(4568), subcategoryService.getSubcategoryById(1L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/premium-photo/3d-rendering-pendant-lamp-isolated-on-white_493806-8663.jpg?w=826"));
            productRepository.save(new Product("Светильник 100вт", new BigDecimal(145), subcategoryService.getSubcategoryById(2L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/free-photo/vertical-selective-focus-shot-streetlight-city-westminster-abbey-road_181624-10688.jpg?t=st=1711289375~exp=1711292975~hmac=0b66bbac6c6d61599ccb15c22853739d83aeb98086fcffa01b4d70ec65a810b5&w=740"));
            productRepository.save(new Product("Светильник 120вт", new BigDecimal(556), subcategoryService.getSubcategoryById(2L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/free-photo/vertical-selective-focus-shot-streetlight-city-westminster-abbey-road_181624-10688.jpg?t=st=1711289375~exp=1711292975~hmac=0b66bbac6c6d61599ccb15c22853739d83aeb98086fcffa01b4d70ec65a810b5&w=740"));
            productRepository.save(new Product("Светильник настольный 60вт", new BigDecimal(2356), subcategoryService.getSubcategoryById(3L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/free-photo/desk-lamp-with-minimalist-monochrome-background_23-2150763368.jpg?w=740"));
            productRepository.save(new Product("Лампа светодиодная 20вт", new BigDecimal(45), subcategoryService.getSubcategoryById(4L), 45L, manufacturerService.getManufacturerById(2L), "https://img.freepik.com/premium-photo/led-bulb-isolated-white-background_984672-1066.jpg?w=740"));
            productRepository.save(new Product("Лампа светодиодная 40вт", new BigDecimal(96), subcategoryService.getSubcategoryById(4L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/premium-photo/led-bulb-isolated-white-background_984672-1066.jpg?w=740"));
            productRepository.save(new Product("Лампа накаливания 60вт", new BigDecimal(25), subcategoryService.getSubcategoryById(5L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/free-photo/you-will-never-leave-me-dark-anymore_144627-4932.jpg?t=st=1711289715~exp=1711293315~hmac=1b758d23dc6cb85fcba21214ffd167fd485b0dbfd8248bfd0c1e28c94c5aba6a&w=740"));
            productRepository.save(new Product("Лампа накаливания 95вт", new BigDecimal(25), subcategoryService.getSubcategoryById(5L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/free-photo/you-will-never-leave-me-dark-anymore_144627-4932.jpg?t=st=1711289715~exp=1711293315~hmac=1b758d23dc6cb85fcba21214ffd167fd485b0dbfd8248bfd0c1e28c94c5aba6a&w=740"));
            productRepository.save(new Product("Лампа люминесцентная 40вт", new BigDecimal(156), subcategoryService.getSubcategoryById(6L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/free-vector/vector-fluorescent-energy-saving-lamps-single-close-up-colored-background_1284-48028.jpg?t=st=1711289874~exp=1711293474~hmac=1d256418c418f3fb79c6e0c4c901a2e48fac7efcb5ee454e69fddd1fd7bbe349&w=740"));
            productRepository.save(new Product("ПУГНП 2* 1,5", new BigDecimal(56), subcategoryService.getSubcategoryById(7L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/free-photo/electric-cables-closeup_93675-129664.jpg?t=st=1711289964~exp=1711293564~hmac=31c76a648fcdd3b2c965229f552196887894ff339fc01119596c284b6b10b59b&w=1380"));
            productRepository.save(new Product("ПВС 2* 2,5", new BigDecimal(86), subcategoryService.getSubcategoryById(8L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/premium-photo/two-wire-multi-core-cable-white-winding_268321-337.jpg?w=1060"));
//            productRepository.save(new Product("Светильник 20вт", new BigDecimal(456), subcategoryService.getSubcategoryById(1L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/premium-photo/3d-rendering-pendant-lamp-isolated-on-white_493806-8663.jpg?w=826"));
//            productRepository.save(new Product("Светильник 20вт", new BigDecimal(456), subcategoryService.getSubcategoryById(1L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/premium-photo/3d-rendering-pendant-lamp-isolated-on-white_493806-8663.jpg?w=826"));
//            productRepository.save(new Product("Светильник 20вт", new BigDecimal(456), subcategoryService.getSubcategoryById(1L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/premium-photo/3d-rendering-pendant-lamp-isolated-on-white_493806-8663.jpg?w=826"));
//            productRepository.save(new Product("Светильник 20вт", new BigDecimal(456), subcategoryService.getSubcategoryById(1L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/premium-photo/3d-rendering-pendant-lamp-isolated-on-white_493806-8663.jpg?w=826"));
//            productRepository.save(new Product("Светильник 20вт", new BigDecimal(456), subcategoryService.getSubcategoryById(1L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/premium-photo/3d-rendering-pendant-lamp-isolated-on-white_493806-8663.jpg?w=826"));
//            productRepository.save(new Product("Светильник 20вт", new BigDecimal(456), subcategoryService.getSubcategoryById(1L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/premium-photo/3d-rendering-pendant-lamp-isolated-on-white_493806-8663.jpg?w=826"));
//            productRepository.save(new Product("Светильник 20вт", new BigDecimal(456), subcategoryService.getSubcategoryById(1L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/premium-photo/3d-rendering-pendant-lamp-isolated-on-white_493806-8663.jpg?w=826"));
//            productRepository.save(new Product("Светильник 20вт", new BigDecimal(456), subcategoryService.getSubcategoryById(1L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/premium-photo/3d-rendering-pendant-lamp-isolated-on-white_493806-8663.jpg?w=826"));
//            productRepository.save(new Product("Светильник 20вт", new BigDecimal(456), subcategoryService.getSubcategoryById(1L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/premium-photo/3d-rendering-pendant-lamp-isolated-on-white_493806-8663.jpg?w=826"));
//            productRepository.save(new Product("Светильник 20вт", new BigDecimal(456), subcategoryService.getSubcategoryById(1L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/premium-photo/3d-rendering-pendant-lamp-isolated-on-white_493806-8663.jpg?w=826"));
//            productRepository.save(new Product("Светильник 20вт", new BigDecimal(456), subcategoryService.getSubcategoryById(1L), 45L, manufacturerService.getManufacturerById(1L), "https://img.freepik.com/premium-photo/3d-rendering-pendant-lamp-isolated-on-white_493806-8663.jpg?w=826"));
        } catch (IllegalAccessException e){

        }

    }
}
