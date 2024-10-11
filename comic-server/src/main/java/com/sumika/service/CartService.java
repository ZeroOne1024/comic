package com.sumika.service;

import com.sumika.entity.Cart;

import java.util.List;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-21 10:03
 */


public interface CartService {
    void insert(List<Cart> cartList);

    List<Cart> selectAllList();

    void deleteCartById(Long id);

    void clear();
}
