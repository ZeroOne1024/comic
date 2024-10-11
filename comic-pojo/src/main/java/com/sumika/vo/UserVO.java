package com.sumika.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-22 14:15
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserVO {

    private Long id;
    private String name;
    private String image;
    private String account;
    private Integer status;
    private Integer type;

    private String phone;
    private String  email;
    private BigDecimal money;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;


}
