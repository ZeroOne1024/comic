package com.sumika.mapper;

import com.sumika.entity.Cart;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-21 10:26
 */


@Mapper
public interface CartMapper {
    void insert(List<Cart> cartList);


    List<Cart> selectAllList();

    @Delete("delete from cart where id = #{id}")
    void deleteCartById(Long id);

    @Delete("delete from cart")
    void clear();

    @Delete("delete from cart where comic_id = #{id}")
    void deleteByComicId(Long id);
}
