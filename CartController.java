package com.example.CartService.controller;

import com.example.CartService.Models.Carts;
import com.example.CartService.Service.CartServices;
import org.springframework.web.bind.annotation.*;

@RestController
public class CartController {

        private final CartServices cartService;
        public CartController(CartServices cartService){

            this.cartService= cartService;
        }
        @GetMapping("/Cart")
        public Carts[] getAllProducts(){

            return cartService.getAllProducts();
        }
        @GetMapping("/Cart/{id}")
        public Carts getSingleProduct(@PathVariable("id")Long id){

            return cartService.getSingleProduct(id);
        }
        @PostMapping("/Cart")
        public Carts addProduct(@RequestBody Carts carts){

            return cartService.addProduct(carts);
        }
        @PatchMapping("/Cart/{id}")
        public Carts updateProduct(@PathVariable("id")Long id){

            return cartService.updateProduct(id);
        }
        @DeleteMapping("/Cart/{id}")
        public Carts deleteProduct(@PathVariable("id")Long id){

            return cartService.deleteProduct(id);
        }
}
