package com.sumika.service.impl;

import com.sumika.context.BaseContext;
import com.sumika.entity.Cart;
import com.sumika.mapper.CartMapper;
import com.sumika.service.CartService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Asuka
 * @Description: \
 * @create: 2024-06-21 10:03
 */

@Service
public class CartServiceImpl implements CartService {


    @Autowired
    private CartMapper cartMapper;

    @Override
    public void insert(List<Cart> cartList) {

        cartList.forEach(cart -> cart.setUserId(BaseContext.getCurrentId()));

        cartMapper.insert(cartList);
    }


    @Override
    public List<Cart> selectAllList() {
        return cartMapper.selectAllList();
    }

    @Override
    public void deleteCartById(Long id) {
        cartMapper.deleteCartById(id);
    }

    @Override
    public void clear() {
        cartMapper.clear();
    }
}
