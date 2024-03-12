package com.example.CartService.Service;

import com.example.CartService.Models.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreCategoryServices implements CategoryServices{

   

        private final RestTemplate restTemplate= new RestTemplate();


        @Override
        public String[] getAllCategories() {
            ResponseEntity<String[]> response =
                    restTemplate.getForEntity(
                            "https://fakestoreapi.com/products/categories",
                            String[].class);
            String[] allCategories = response.getBody();
            return allCategories;

        }

        @Override
        public Category getInCategory(String name) {
            Category newCategory = new Category(name);
            return newCategory;
        }
    }
