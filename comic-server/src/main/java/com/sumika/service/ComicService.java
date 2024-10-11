package com.sumika.service;

import com.sumika.dto.ComicInsertDTO;
import com.sumika.dto.ComicListDTO;
import com.sumika.dto.SearchComicDTO;
import com.sumika.entity.Comic;
import com.sumika.result.PageResult;
import com.sumika.vo.ComicTagVolumeVO;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-20 15:44
 */


public interface ComicService {
    PageResult getAllList(ComicListDTO comicListDTO);

    PageResult searchList(SearchComicDTO searchComicDTO);

    void insert(ComicInsertDTO comicInsertDTO);

    void delete(Long id);

    ComicTagVolumeVO getComicTagVolumeById(Long id);

    void update(Comic comic);
}
