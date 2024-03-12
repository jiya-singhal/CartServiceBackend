package com.example.CartService.Service;
import java.util.List;
import com.example.CartService.Models.Carts;

public abstract class CartServices {
    public abstract Carts[] getAllProducts() ;
    public abstract Carts getSingleProduct(Long id);
     public abstract Carts addProduct(Carts carts);
    public abstract Carts updateProduct(Long id);
    public abstract Carts deleteProduct(Long id);
}
