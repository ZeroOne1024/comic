package com.sumika.interceptor;

import com.sumika.constant.JwtClaimsConstant;
import com.sumika.constant.UserConstant;
import com.sumika.context.BaseContext;
import com.sumika.properties.JwtProperties;
import com.sumika.utils.JwtUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import io.jsonwebtoken.Claims;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-18 10:21
 */

@Component
@Slf4j
public class JwtTokenInterceptor implements HandlerInterceptor {

    @Autowired
    private JwtProperties jwtProperties;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.info("当前拦截器线程id: {} ",Thread.currentThread().getId());

        if( !(handler instanceof HandlerMethod)){
            return true;
        }

        log.info("url,{}",request.getRequestURL().toString());
        System.out.println(request.getRequestURI());
        if(request.getRequestURL().toString().contains("image/")){
            return true;
        }

        if(request.getRequestURL().toString().contains("user/login") || request.getRequestURL().toString().contains("user/register")){
            return true;
        }

        String token = request.getHeader(jwtProperties.getTokenName());

        try {
            log.info("jwt校验:{}",token);
            Claims claims = JwtUtil.parseJWT(jwtProperties.getTokenKey(),token);
            Long userId = Long.valueOf(claims.get(JwtClaimsConstant.USER_ID).toString());
            Integer type = Integer.valueOf(claims.get(JwtClaimsConstant.TYPE).toString());

            //将id存到线程里
            BaseContext.setCurrentId(userId);

            log.info("当前员工id:{}",userId);

            if(request.getRequestURL().toString().contains("admin/")){
                return type.equals(UserConstant.ADMIN);
            }


            return true;
        }catch (Exception e){
            response.setStatus(401);
            return false;
        }
    }


}
