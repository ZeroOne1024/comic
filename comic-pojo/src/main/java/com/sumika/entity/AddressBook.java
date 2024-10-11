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
 * @create: 2024-06-19 08:41
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddressBook implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long userId;
    private Integer defaul;
    private String phone;
    private String detailedAddress;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;


}
