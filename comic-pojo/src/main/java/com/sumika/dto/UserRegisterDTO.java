package com.sumika.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-18 10:55
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserRegisterDTO {

    private String name;
    private String image;
    private String account;
    private String  password;
    private String phone;


}
