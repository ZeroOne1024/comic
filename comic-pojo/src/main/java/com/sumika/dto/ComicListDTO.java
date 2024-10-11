package com.sumika.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-20 15:48
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ComicListDTO {

    private Integer page;
    private Integer pageSize;

}
