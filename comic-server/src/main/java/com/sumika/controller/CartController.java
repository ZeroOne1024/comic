package com.sumika.controller;

import com.sumika.dto.CartDTO;
import com.sumika.entity.Cart;
import com.sumika.result.Result;
import com.sumika.service.CartService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-21 10:02
 */

@RequestMapping("/cart")
@RestController
@Slf4j
@CrossOrigin
public class CartController {


    @Autowired
    private CartService cartService;


    @PutMapping
    public Result addCart(@RequestBody  ArrayList<CartDTO> list){

        //cartService.insert(cartList);
        List<Cart> cartList = new ArrayList<>();

        for (CartDTO dto : list) {
            Cart c = new Cart();
            BeanUtils.copyProperties(dto,c);
            cartList.add(c);
        }

        cartService.insert(cartList);

        return Result.success();
    }


    @GetMapping
    public Result<List<Cart>> getCartList(){

        return Result.success(cartService.selectAllList());
    }

    @DeleteMapping("/{id}")
    public Result deleteCartById(@PathVariable Long id){
        cartService.deleteCartById(id);
        return Result.success();
    }

    @DeleteMapping("/clear")
    public Result clear(){
        cartService.clear();
        return Result.success();
    }

}
