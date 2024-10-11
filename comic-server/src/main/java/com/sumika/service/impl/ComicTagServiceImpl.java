package com.sumika.service.impl;

import com.sumika.entity.ComicTag;
import com.sumika.mapper.ComicTagMapper;
import com.sumika.service.ComicTagSevice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-26 12:48
 */

@Service
@Slf4j
public class ComicTagServiceImpl implements ComicTagSevice {

    @Autowired
    private ComicTagMapper comicTagMapper;

    @Override
    public void insert(ComicTag comicTag) {
        comicTagMapper.insert(comicTag);
    }

    @Override
    public void delete(ComicTag comicTag) {
        comicTagMapper.deleteByComicTagId(comicTag);
    }
}
