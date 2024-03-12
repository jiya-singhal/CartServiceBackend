package com.example.CartService.Models;


import Dto.FakeStoreCartDto;
import lombok.Getter;
import lombok.Setter;

    @Getter
    @Setter
    public class Carts {
        private long id;
        private String name;
        private String description;
        private double price;
        private Category category;
        private String imageUrl;

    }


