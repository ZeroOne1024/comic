package com.sumika.mapper;

import com.sumika.annotation.AutoFill;
import com.sumika.entity.User;
import com.sumika.enumeration.OperationType;
import com.sumika.vo.UserVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-18 11:29
 */

@Mapper
public interface UserMapper {

    @AutoFill(OperationType.INSERT)
    void insert(User user);

    List<User> select(User user);

    @Select("select * from user where account = #{account}")
    User selectByAccount(String account);

    @Select("select * from user where account = #{account} and password = #{password}")
    User login(User u);

    @AutoFill(OperationType.UPDATE)
    void updateById(User user);


    UserVO getDataById(Long id);

    @Select("select * from user where account = #{account}")
    User accountExist(String account);

    @Select("select * from user where account = #{account} and password = #{password}")
    User passwordCheck(User user);
}
