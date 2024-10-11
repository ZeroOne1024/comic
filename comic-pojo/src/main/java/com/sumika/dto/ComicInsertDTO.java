package com.sumika.dto;

import com.sumika.entity.ComicVolume;
import com.sumika.entity.Tag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-26 00:32
 */

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComicInsertDTO {


    private String image;
    private String name;
    private String author;
    private Integer state;
    private Integer serialState;
    private String describe;
    private BigDecimal score;
    private LocalDate releaseDate;

    private List<Long> tagList;

    private List<ComicVolume> volumeList;
}
