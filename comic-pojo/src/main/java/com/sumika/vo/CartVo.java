package com.sumika.vo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-21 18:42
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartVo {


    private String comicNane;
    private Long comicId;
    private Long comicVolumeId;
    private BigDecimal money;
    private String image;
    private Integer serialNumber;


}
