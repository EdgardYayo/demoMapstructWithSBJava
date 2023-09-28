package com.edydev.mapStructLombokDemo.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Mappings;
import org.springframework.beans.factory.annotation.Autowired;

import com.edydev.mapStructLombokDemo.dto.GetCategory;
import com.edydev.mapStructLombokDemo.entity.Category;
import com.edydev.mapStructLombokDemo.repository.CategoryRepository;

//Para hacerlo sin inyeccion de dependencias seria
//@Mapper() annotion mapper vacia 

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class CategoryMapper {
    

    // Y aqui generamos una instancia publica
    // public CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);

    @Autowired
    private CategoryRepository categoryRepository;

    @Mappings( {
        @Mapping(source = "id", target = "categoryId"),    
        @Mapping(source = "name", target = "categoryName")
    })
    abstract GetCategory toGetCategory(Category category);

    Category toEntity(GetCategory getCategory){
        if(getCategory == null) return null;

        Category category = categoryRepository.findById(getCategory.getCategoryId()).orElse(null);

        if(category == null) return null;
        category.setId(getCategory.getCategoryId());
        category.setName(getCategory.getCategoryName());
        return category;

    }

    abstract List<GetCategory> toGetCategoryList(List<Category> categoryList);    
    
    abstract List<Category> toEntityList(List<GetCategory> getCategoryList);

}
