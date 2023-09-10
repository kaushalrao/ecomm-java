package com.ecomm.shop.controller;

import com.ecomm.shop.model.Cart;
import com.ecomm.shop.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class CartController {

    @Autowired
    private CartService cartService;

    @GetMapping("carts")
    public ResponseEntity<List<Cart>> getAllCart(){

        List<Cart> carts = cartService.listCarts();
        return new ResponseEntity<List<Cart>>(carts, HttpStatus.OK);

    }

    @GetMapping("cart/{id}")
    public ResponseEntity< Optional<Cart>> getCart(@PathVariable("id") Integer id){
        Optional<Cart> book = cartService.getCart(id);
        return new ResponseEntity<Optional<Cart>>(book, HttpStatus.OK);
    }

    @PostMapping("cart")
    public ResponseEntity<Cart> createBook(@RequestBody Cart cart){
        Cart b = cartService.createCart(cart);
        return new ResponseEntity<Cart>(b, HttpStatus.OK);
    }
}