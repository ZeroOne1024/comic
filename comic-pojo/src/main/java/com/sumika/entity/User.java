package com.sumika.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-18 11:06
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User implements Serializable {

    private static final long serialVersionUID = 1L;


    private Long id;
    private String name;
    private String image;
    private String account;
    private String password;
    private Integer status;
    private Integer type;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;

}
