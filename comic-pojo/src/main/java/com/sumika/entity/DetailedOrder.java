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
 * @create: 2024-06-19 08:48
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class DetailedOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long orderId;
    private Long comicId;
    private Long comicVolumeId;
    private Integer number;
    private BigDecimal money;
    private BigDecimal price;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;


}
