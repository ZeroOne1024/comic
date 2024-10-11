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
 * @create: 2024-06-19 08:50
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Order implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;
    private Long userId;
    private String orderNumber;
    private Integer state;
    private BigDecimal sumMoney;
    private LocalDateTime payTime;
    private Long addressBookId;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;


}
