package com.example.CartService.controller;

import com.example.CartService.Service.CategoryServices;
import jdk.jfr.Category;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
        private CategoryServices categoryServices;
        CategoryController(CategoryServices categoryServices){
            this.categoryServices=categoryServices;
        }
        @GetMapping("/products/categories")
        public String[] getAllCategories(){
            return categoryServices.getAllCategories();
        }
        @GetMapping("/products/categories/{categoryName}")
        public Category getInCategory(@PathVariable("categoryName")String categoryName){

            return (Category) categoryServices.getInCategory(categoryName);
        }

    }

