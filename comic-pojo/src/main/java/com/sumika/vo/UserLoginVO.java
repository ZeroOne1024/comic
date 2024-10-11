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
 * @create: 2024-06-18 11:15
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserLoginVO {

    private Long id;
    private String name;
    private String image;
    private Integer type;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private String token;
}
