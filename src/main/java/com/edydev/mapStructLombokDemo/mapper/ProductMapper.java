package com.edydev.mapStructLombokDemo.mapper;

import java.util.List;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;

import com.edydev.mapStructLombokDemo.dto.GetProduct;
import com.edydev.mapStructLombokDemo.entity.Product;

//@Mapper(uses = {CategoryMapper.class})

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING, uses = {CategoryMapper.class})
public interface ProductMapper {
    

    // Y aqui generamos una instancia publica
    // public ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);


    @Mappings( {
        @Mapping(source = "id", target = "productId"),    
        @Mapping(source = "name", target = "productName"),
        @Mapping(source = "price", target = "price", numberFormat = "$#.00"),
        @Mapping(source = "creationDate", target = "creationDate", 
                                          dateFormat = "yyyy-MM-dd")
    })
   
    GetProduct toGetDTO(Product product);

    //Esta parte si queremos ignorar una propiedad
    // @Mappings( {
        //     @Mapping(target = "creationDate", ignore = true)    
        // })
    @InheritInverseConfiguration
    Product toEntity(GetProduct getProduct);

    List<GetProduct> toGetProductList(List<Product> productList);

    List<Product> toEntityList(List<GetProduct> getProductList);
}
