package com.sumika.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-20 18:11
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TagComicDTO {

    private Long id;
    private String name;
    private Long comicId;

}
