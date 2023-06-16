package com.denis.productscategories.services;

import com.denis.productscategories.models.Category;
import com.denis.productscategories.models.Product;
import com.denis.productscategories.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    ProductRepository productRepository;

    public List<Product> allProducts(){
        return productRepository.findAll();
    }

    public Product findProduct (Long id){
        Optional<Product> optionalProduct = productRepository.findById(id);
        if(optionalProduct.isPresent()){
            return optionalProduct.get();
        }else{
            return null;
        }
    }

    public void createProduct(Product product){
        productRepository.save(product);
    }

    public void updateProduct(Product product){
        productRepository.save(product);
    }

    public List<Product> getProductsByCategory(Category category){
        return productRepository.findAllByCategories(category);
    }

    public List<Product> getProductsNotInCategory(Category category){
        return productRepository.findAllByCategoriesNotContains(category);
    }
}
