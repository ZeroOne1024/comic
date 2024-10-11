package com.sumika.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-21 10:15
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Cart {

    private Long id;
    private Long comicId;
    private Long comicVolumeId;
    private Long userId;
    private BigDecimal money;
    private String image;
    private String comicName;
    private Integer serialNumber;
}
