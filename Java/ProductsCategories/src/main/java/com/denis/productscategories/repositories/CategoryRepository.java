package com.denis.productscategories.repositories;

import com.denis.productscategories.models.Category;
import com.denis.productscategories.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Long> {
    List<Category> findAll();
    List<Category> findAllByProducts(Product product);
    List<Category> findByProductsNotContains(Product product);

}
