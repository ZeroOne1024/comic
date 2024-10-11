package com.sumika.service.impl;

import com.sumika.entity.ComicVolume;
import com.sumika.mapper.ComicVolumeMapper;
import com.sumika.service.ComicVolumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-20 23:52
 */

@Service
public class ComicVolumeServiceImpl implements ComicVolumeService {

    @Autowired
    private ComicVolumeMapper comicVolumeMapper;


    @Override
    public List<ComicVolume> serialNumberList(Integer comicId) {

        return comicVolumeMapper.serialNumberList(comicId);
    }

    @Override
    public void update(ComicVolume comicVolume) {
        comicVolumeMapper.update(comicVolume);
    }

    @Override
    public List<ComicVolume> getByComicId(Integer id) {
        return comicVolumeMapper.getByComicId(id);
    }

    @Override
    public void insert(ComicVolume comicVolume) {
        comicVolume.setState(0);
        comicVolume.setScore(BigDecimal.valueOf(5));

        comicVolumeMapper.insert(comicVolume);
    }

    @Override
    public void insertList(ArrayList<ComicVolume> volumes) {
        volumes.forEach(v->{
            v.setState(0);
            v.setScore(BigDecimal.valueOf(5));
            v.setCreateTime(LocalDateTime.now());
            v.setUpdateTime(LocalDateTime.now());
        });
        comicVolumeMapper.insertList(volumes);
    }


    @Override
    public void deleteById(Long id) {
        comicVolumeMapper.deleteById(id);
    }
}
