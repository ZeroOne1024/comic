package com.sumika.service.impl;

import com.sumika.entity.Tag;
import com.sumika.mapper.TagMapper;
import com.sumika.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-20 23:48
 */

@Service
public class TagServiceImpl implements TagService {


    @Autowired
    private TagMapper tagMapper;

    @Override
    public List<Tag> selectAll() {
        return tagMapper.selectAll();
    }


    @Override
    public List<Tag> getTagListByComicId(Long id) {

        return tagMapper.selectByComicId(id);
    }
}
