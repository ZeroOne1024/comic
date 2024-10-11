package com.sumika.controller;

import com.sumika.constant.JwtClaimsConstant;
import com.sumika.constant.MessageConstant;
import com.sumika.context.BaseContext;
import com.sumika.dto.UserLoginDTO;
import com.sumika.dto.UserRegisterDTO;
import com.sumika.dto.UserUpdateDTO;
import com.sumika.entity.User;
import com.sumika.properties.JwtProperties;
import com.sumika.result.Result;
import com.sumika.service.UserService;
import com.sumika.utils.JwtUtil;
import com.sumika.vo.UserLoginVO;
import com.sumika.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-18 10:50
 */

@RestController
@RequestMapping("/user")
@Slf4j
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtProperties jwtProperties;


    @PutMapping("/register")
    public Result register(@RequestBody UserRegisterDTO userRegisterDTO){
        userService.register(userRegisterDTO);
        return Result.success();
    }


    @PostMapping("/login")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO){
        log.info("用户登录,{}",userLoginDTO);
        User user = userService.login(userLoginDTO);

        Map<String,Object> map = new HashMap<>();
        map.put(JwtClaimsConstant.USER_ID,user.getId());
        map.put(JwtClaimsConstant.TYPE,user.getType());

        String token = JwtUtil.createJWT(jwtProperties.getTokenKey(),jwtProperties.getTokenKeyOutTime(),map);

        UserLoginVO userLoginVO = new UserLoginVO();

        BeanUtils.copyProperties(user,userLoginVO);

        userLoginVO.setToken(token);

        return Result.success(userLoginVO);
    }

    @PostMapping
    public Result updateUserAndDetail(@RequestBody UserUpdateDTO userUpdateDTO){

        userService.updateUserAndDetail(userUpdateDTO);

        return Result.success();
    }


    @GetMapping("/{id}")
    public Result getUserData(@PathVariable Long id){
        UserVO vo =userService.getUserData(id);
        return Result.success(vo);
    }

    @GetMapping
    public Result getTokenUser(){
        Long id = BaseContext.getCurrentId();
        UserVO vo =userService.getUserData(id);
        return Result.success(vo);
    }

    @GetMapping("/accountcheck/{account}")
    public Result accountCheck(@PathVariable String account){

        if(!userService.accountExist(account)){
            return Result.success();
        }else {
            return Result.error(MessageConstant.ACCOUNT_EXIS);
        }
    }


    @PostMapping("/passwordcheck")
    public Result passwordCheck(@RequestBody User user){

        if(userService.passwordCheck(user)){
            return Result.success();
        }else{
            return Result.error(MessageConstant.PASSWORD_ERROR);
        }
    }
}
