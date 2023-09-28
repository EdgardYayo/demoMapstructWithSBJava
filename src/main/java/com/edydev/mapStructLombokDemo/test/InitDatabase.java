package com.edydev.mapStructLombokDemo.test;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.edydev.mapStructLombokDemo.dto.GetProduct;
import com.edydev.mapStructLombokDemo.entity.Product;
import com.edydev.mapStructLombokDemo.mapper.ProductMapper;
import com.edydev.mapStructLombokDemo.repository.ProductRepository;

@Configuration
public class InitDatabase {
    
    @Autowired
    private ProductRepository productRepository;


    // Y Aqui ya no se deberia inyectar se debe declarar asi 
    // private ProductMapper productMapper = ProductMapper.INSTANCE;
    @Autowired
    private ProductMapper productMapper;

    @Bean
    public CommandLineRunner testProductMapperCommand(){
        return args -> {
            List<Product> products = productRepository.findAll();
            System.out.println("PRODUCTS");
            //Esta es la manera abreviada de esto
            //products.forEach(product -> System.out.println(product));
            products.forEach(System.out::println);

            List<GetProduct> getProductList = productMapper.toGetProductList(products);
            getProductList.forEach(System.out::println);

            System.out.println("MAPPED PRODUCTS");

            List<Product> mappedProducts = productMapper.toEntityList(getProductList);
            mappedProducts.forEach(System.out::println);
        };
    }
}
