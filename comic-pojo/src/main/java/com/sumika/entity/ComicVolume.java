package com.sumika.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-19 08:44
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ComicVolume implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long comicId;
    private String name;
    private String image;
    private Integer state;
    private Integer serialNumber;
    private BigDecimal money;
    private LocalDate releaseDate;
    private Integer stock;
    private BigDecimal score;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
