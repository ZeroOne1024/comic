package com.sumika.service;

import com.sumika.dto.UserLoginDTO;
import com.sumika.dto.UserRegisterDTO;
import com.sumika.dto.UserUpdateDTO;
import com.sumika.entity.User;
import com.sumika.vo.UserLoginVO;
import com.sumika.vo.UserVO;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-18 11:01
 */


public interface UserService {
    User login(UserLoginDTO userLoginDTO);

    void register(UserRegisterDTO userRegisterDTO);

    UserVO getUserData(Long id);

    boolean accountExist(String account);

    boolean passwordCheck(User user);

    void updateUserAndDetail(UserUpdateDTO userUpdateDTO);
}
