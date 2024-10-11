package com.sumika.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-21 15:33
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDTO {

    private Long comicId;
    private Long comicVolumeId;
    private BigDecimal money;
    private String image;
    private Integer serialNumber;

}
