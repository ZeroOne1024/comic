package com.sumika.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-19 08:54
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Tag implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;

}
