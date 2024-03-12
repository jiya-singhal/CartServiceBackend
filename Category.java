package com.example.CartService.Models;


    import lombok.Getter;
import lombok.Setter;

    @Getter
    @Setter
    public class Category {
        private long id;
        private String name;

        public Category(String name){
            this.name=name;
        }
    }
