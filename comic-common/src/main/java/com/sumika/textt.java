package com.sumika;

import org.springframework.util.DigestUtils;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-18 12:48
 */


public class textt {
    public static void main(String[] args) {
        System.out.println(DigestUtils.md5DigestAsHex("Asuka".getBytes()).length());
    }
}
