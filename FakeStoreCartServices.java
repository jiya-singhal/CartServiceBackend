package com.example.CartService.Service;

import Dto.FakeStoreCartDto;
import com.example.CartService.Models.Carts;
import com.example.CartService.Models.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class FakeStoreCartServices extends CartServices {
        private RestTemplate restTemplate = new RestTemplate();

        @Override
        public Carts[] getAllProducts() {

            ResponseEntity<Carts[]> response =
                    restTemplate.getForEntity(
                            "https://fakestoreapi.com/cart",
                            Carts[].class);
            Carts[] allProducts = response.getBody();

            return allProducts;
        }

        @Override
        public Carts getSingleProduct(Long id) {
            FakeStoreCartDto fakeStoreProductDto = restTemplate.getForObject(
                    "https://fakestoreapi.com/carts/"+id,
                    FakeStoreCartDto.class
            );
            Carts carts = new Carts();
            Carts.setId(fakeStoreProductDto.getId());
            Carts.setName(fakeStoreProductDto.getTitle());
            Carts.setPrice(fakeStoreProductDto.getPrice());
            Carts.setImageUrl(fakeStoreProductDto.getImage());
            Carts.setCategory(new Category(fakeStoreProductDto.getClass()));


            return carts;
        }

        @Override
        public Carts addProduct(Carts carts) {

            FakeStoreCartDto newProduct = new FakeStoreCartDto();
            newProduct.setId(carts.getId());
            newProduct.setTitle(carts.getName());
            newProduct.setDescription(carts.getDescription());
            newProduct.setPrice(carts.getPrice());
            newProduct.setCategory(carts.getCategory().getName());

            restTemplate.postForObject(
                    "https://fakestoreapi.com/cart/",
                    newProduct,
                    FakeStoreCartDto.class
            );

            return carts;
        }
        public Carts updateProduct(Long id){

            Carts carts = getSingleProduct(id);
            FakeStoreCartDto newProduct = new FakeStoreCartDto();
            //update whatever you want
            newProduct.setId(carts.getId());
            newProduct.setImage(carts.getImageUrl());
            newProduct.setPrice(carts.getPrice());
            newProduct.setCategory(carts.getCategory().getName());
            newProduct.setDescription(carts.getDescription());
            newProduct.setTitle(carts.getName());

            // update fields


            restTemplate.put(
                    "https://fakestoreapi.com/carts/"+id,newProduct
            );
            return carts;
        }
        public Carts deleteProduct(Long id){
            Carts productToBeDeleted = getSingleProduct(id);
            restTemplate.delete("https://fakestoreapi.com/"+id);

            return productToBeDeleted;
        }


}
