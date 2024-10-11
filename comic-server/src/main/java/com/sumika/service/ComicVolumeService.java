package com.sumika.service;

import com.sumika.entity.ComicVolume;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-20 23:52
 */


public interface ComicVolumeService {
    List<ComicVolume> serialNumberList(Integer comicId);

    void update(ComicVolume comicVolume);

    List<ComicVolume> getByComicId(Integer id);

    void insert(ComicVolume comicVolume);

    void insertList(ArrayList<ComicVolume> volumes);

    void deleteById(Long id);
}
