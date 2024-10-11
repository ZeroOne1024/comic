package com.sumika.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-18 12:23
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailedUser implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long userId;
    private String phone;
    private String email;
    private BigDecimal money;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
