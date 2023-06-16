package com.denis.productscategories.controllers;

import com.denis.productscategories.models.Category;
import com.denis.productscategories.models.Product;
import com.denis.productscategories.services.CategoryService;
import com.denis.productscategories.services.ProductService;
import jakarta.validation.Valid;
import org.eclipse.tags.shaded.org.apache.xpath.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
public class HomeController {

    @Autowired
    ProductService productService;

    @Autowired
    CategoryService categoryService;


    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("products",productService.allProducts());
        model.addAttribute("categories",categoryService.allCategories());
        return "index";
    }

    @GetMapping("/products/new")
    public String newProduct(@ModelAttribute("product")Product product){
        return"newproduct";
    }

    @GetMapping("/categories/new")
    public String newCategory(@ModelAttribute("category")Category category){
        return "newcategory";
    }

    @GetMapping("/products/{productId}")
    public String productAddCategory(@PathVariable("productId") Long productId, Model model){
        Product showProduct = productService.findProduct(productId);
        model.addAttribute("showProduct",showProduct);
        model.addAttribute("categories",categoryService.getCategoriesByProduct(showProduct));
        model.addAttribute("notCategories",categoryService.getCategoriesNotInProduct(showProduct));

        return "showproduct";
    }

    @GetMapping("/categories/{categoryId}")
    public String categoryAddProduct(@PathVariable("categoryId") Long categoryId, Model model){
        Category showCategory = categoryService.findCategory(categoryId);
        model.addAttribute("showCategory",showCategory);
        model.addAttribute("products",productService.getProductsByCategory(showCategory));
        model.addAttribute("notProducts",productService.getProductsNotInCategory(showCategory));

        return "showcategory";
    }

    @PostMapping("/categories/{categoryId}")
    public String updateCategory(@PathVariable("categoryId") Long categoryId, @RequestParam(value="productId") Long productId) {
        Category category = categoryService.findCategory(categoryId);
        Product product = productService.findProduct(productId);
        category.getProducts().add(product);
        categoryService.updateCategory(category);
        return "redirect:/";
    }

    @PostMapping("/products/{productId}")
    public String updateProduct(@PathVariable("productId") Long productId, @RequestParam(value="categoryId") Long categoryId) {
        Product product = productService.findProduct(productId);
        Category category = categoryService.findCategory(categoryId);
        product.getCategories().add(category);
        productService.updateProduct(product);
        return "redirect:/";
    }

    @PostMapping("/addcategory")
    public String addingCategory(@Valid @ModelAttribute("category") Category category,
                                 BindingResult result){
        if ((result.hasErrors())){
            return"newcategory";
        }

        categoryService.createCategory(category);
        return "redirect:/";
    }

    @PostMapping("/addproduct")
    public String addingProduct(@Valid @ModelAttribute("product") Product product,
                                BindingResult result){
        if(result.hasErrors()){
            return "newproduct";
        }

        productService.createProduct(product);
        return "redirect:/";
    }
}
