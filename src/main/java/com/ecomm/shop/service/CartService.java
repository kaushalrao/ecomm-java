package com.ecomm.shop.service;

import com.ecomm.shop.model.Cart;
import com.ecomm.shop.model.Product;
import com.ecomm.shop.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    public List<Cart> listCarts( ) {
        return cartRepository.findAll();
    }

    public Optional<Cart> getCart(int cartId) {
        return cartRepository.findById(cartId);
    }
    public Cart createCart(Cart cart) {
        Cart existingCart = cartRepository.findById(cart.getId()).orElse(new Cart());
        if(existingCart.getProduct() !=null) {
            if(!existingCart.getProduct().contains(cart.getProduct().get(0)))
            {
                List<Product> products = existingCart.getProduct();
                products.add(cart.getProduct().get(0));
                cart.setProduct(products);
            }
            else{
                cart.setProduct(existingCart.getProduct());
            }
        }
        return cartRepository.save(cart);
    }
}