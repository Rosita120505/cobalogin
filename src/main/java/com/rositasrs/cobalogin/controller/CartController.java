package com.rositasrs.cobalogin.controller;


import com.rositasrs.cobalogin.model.dto.CartDto;
import com.rositasrs.cobalogin.model.dto.DefaultResponse;
import com.rositasrs.cobalogin.model.entity.Cart;
import com.rositasrs.cobalogin.repository.CartRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cart")
public class CartController {
    private final CartRepository cartRepository;

    public CartController (CartRepository cartRepository){
        this.cartRepository = cartRepository;
    }
    @GetMapping("/keranjang")
    public List<CartDto> getListCart(){
        List<CartDto> list = new ArrayList<>();
        for(Cart c : cartRepository.findAll()){
            list.add(convertEntityToDto(c));
        }
        return list;
    }
    @PostMapping("/simpan")
    public DefaultResponse<CartDto> saveOrder(@RequestBody CartDto cartDto){
        Cart cart = convertDtotoEntity(cartDto);
        DefaultResponse<CartDto> response = new DefaultResponse<>();
        Optional<Cart> optionalCart = cartRepository.findByCartId(cartDto.getCartId());
        if(optionalCart.isPresent()){
            response.setMessage("Gagal Menyimpan Ke Keranjang");
        } else{
            cartRepository.save(cart);
            response.setMessage("Berhasil Tersimpan Di Keranjang");
            response.setData(cartDto);
        }
        return response;
    }
    public Cart convertDtotoEntity(CartDto dto){
        Cart cart = new Cart();
        cart.setCartId(dto.getCartId());
        cart.setNumberofOrder(dto.getNumberofOrder());
        cart.setTotal(dto.getTotal());

        return cart;
    }
    public CartDto convertEntityToDto(Cart entity){
        CartDto dto = new CartDto();
        dto.setCartId(entity.getCartId());
        dto.setNumberofOrder(entity.getNumberofOrder());
        dto.setTotal(entity.getTotal());

        return dto;

    }

}
