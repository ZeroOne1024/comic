package com.sumika.service.impl;

import com.sumika.constant.MessageConstant;
import com.sumika.constant.UserConstant;
import com.sumika.dto.UserLoginDTO;
import com.sumika.dto.UserRegisterDTO;
import com.sumika.dto.UserUpdateDTO;
import com.sumika.entity.DetailedUser;
import com.sumika.entity.User;
import com.sumika.exception.UserException;
import com.sumika.mapper.DetailedUserMapper;
import com.sumika.mapper.UserMapper;
import com.sumika.service.UserService;
import com.sumika.vo.UserLoginVO;
import com.sumika.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-18 11:02
 */

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DetailedUserMapper detailedUserMapper;


    @Override

    public User login(UserLoginDTO userLoginDTO) {
        User u = new User();

        u.setAccount(userLoginDTO.getAccount());
        u.setPassword(DigestUtils.md5DigestAsHex(userLoginDTO.getPassword().getBytes()));

        User user = userMapper.login(u);

        if(user == null){
            throw new UserException(MessageConstant.ACCOUNT_UN_EXIS);
        }


        return user;
    }

    @Override
    @Transactional
    public void register(UserRegisterDTO userRegisterDTO) {
        User u = userMapper.selectByAccount(userRegisterDTO.getAccount());

        if(u != null){
            throw new UserException(MessageConstant.ACCOUNT_EXIS);
        }

        User user = new User();

        BeanUtils.copyProperties(userRegisterDTO,user);

        user.setStatus(UserConstant.ENABLE);
        user.setType(UserConstant.FREEZE);

        //md5加密
        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(password);

        userMapper.insert(user);


        //插入用户详细表
        DetailedUser detailedUser = new DetailedUser();
        BeanUtils.copyProperties(userRegisterDTO,detailedUser);
        detailedUser.setUserId(user.getId());

        detailedUserMapper.insert(detailedUser);

    }


    @Override
    public UserVO getUserData(Long id) {
        UserVO u = userMapper.getDataById(id);

        return u;
    }


    @Override
    public boolean accountExist(String account) {

        User user = userMapper.accountExist(account);

        return user != null;

    }


    @Override
    public boolean passwordCheck(User user) {

        String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
        user.setPassword(password);

        User u = userMapper.passwordCheck(user);

        return u != null;
    }


    @Override
    @Transactional
    public void updateUserAndDetail(UserUpdateDTO userUpdateDTO) {
        User user = new User();
        BeanUtils.copyProperties(userUpdateDTO,user);

        if (userUpdateDTO.getPassword() != null && userUpdateDTO.getPassword() != ""){
            String password = DigestUtils.md5DigestAsHex(user.getPassword().getBytes());
            user.setPassword(password);
        }

        userMapper.updateById(user);

        DetailedUser du = new DetailedUser();

        BeanUtils.copyProperties(userUpdateDTO,du);
        du.setId(null);
        du.setUserId(userUpdateDTO.getId());

        detailedUserMapper.updateByUserId(du);
    }
}
