package com.sumika.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-26 12:43
 */


@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class ComicTag {

    private Long id;
    private Long comicId;
    private Long tagId;

}
