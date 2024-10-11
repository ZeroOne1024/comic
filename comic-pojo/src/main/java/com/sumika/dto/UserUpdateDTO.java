package com.sumika.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-25 10:57
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserUpdateDTO {

    private Long id;
    private String name;
    private String image;
    private String account;
    private String password;
    private Integer status;
    private Integer type;
    private String phone;
    private String email;
    private BigDecimal money;



}
