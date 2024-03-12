package com.example.CartService.Service;

import com.example.CartService.Models.Category;

    public interface CategoryServices {

        String[] getAllCategories();
        Category getInCategory(String name);
    }

