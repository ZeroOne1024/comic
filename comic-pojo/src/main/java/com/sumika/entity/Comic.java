package com.sumika.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-18 10:09
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Comic implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String image;
    private String name;
    private String author;
    private Integer state;
    private Integer serialState;
    private String describe;
    private BigDecimal score;
    private LocalDate releaseDate;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

    private List<Tag> tagList;

}
