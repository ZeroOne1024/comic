package com.sumika.service;

import com.sumika.entity.Tag;

import java.util.List;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-20 23:48
 */


public interface TagService {
    List<Tag> selectAll();

    List<Tag> getTagListByComicId(Long id);
}
