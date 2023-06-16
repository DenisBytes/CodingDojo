package com.denis.productscategories.repositories;

import com.denis.productscategories.models.Category;
import com.denis.productscategories.models.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {
    List<Product> findAll();

    List<Product> findAllByCategories(Category category);

    List<Product> findAllByCategoriesNotContains(Category category);
}
