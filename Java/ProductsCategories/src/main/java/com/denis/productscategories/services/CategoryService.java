package com.denis.productscategories.services;

import com.denis.productscategories.models.Category;
import com.denis.productscategories.models.Product;
import com.denis.productscategories.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    public List<Category> allCategories(){
        return categoryRepository.findAll();
    }
    public Category findCategory (Long id){
        Optional<Category> optionalCategory = categoryRepository.findById(id);
        if(optionalCategory.isPresent()){
            return optionalCategory.get();
        }else{
            return null;
        }
    }

    public void createCategory(Category category){
        categoryRepository.save(category);
    }

    public void updateCategory(Category category){
        categoryRepository.save(category);
    }

    public List<Category> getCategoriesByProduct(Product product){
        return categoryRepository.findAllByProducts(product);
    }

    public List<Category> getCategoriesNotInProduct(Product product){
        return categoryRepository.findByProductsNotContains(product);
    }
}
