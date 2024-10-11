package com.sumika.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-20 15:37
 */


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SearchComicDTO {


    private String name;
    private String author;

    /*0   1连载 2完结*/
    private Integer serialState;
    private LocalDate releaseDateStart;
    private LocalDate releaseDateEnd;

    private Integer tagId;

    //0时间排序 1销量 2发布时间 3评分
    private Integer sort;

    private Integer page;
    private Integer pageSize;
}
