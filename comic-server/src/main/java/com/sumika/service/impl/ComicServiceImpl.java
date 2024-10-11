package com.sumika.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.sumika.dto.ComicInsertDTO;
import com.sumika.dto.ComicListDTO;
import com.sumika.dto.SearchComicDTO;
import com.sumika.dto.TagComicDTO;
import com.sumika.entity.Comic;
import com.sumika.entity.Tag;
import com.sumika.mapper.*;
import com.sumika.result.PageResult;
import com.sumika.service.ComicService;
import com.sumika.vo.ComicTagVolumeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-20 15:44
 */

@Service
@Slf4j
public class ComicServiceImpl implements ComicService {

    @Autowired
    private ComicMapper comicMapper;

    @Autowired
    private TagMapper tagMapper;

    @Autowired
    private ComicVolumeMapper comicVolumeMapper;

    @Autowired
    private ComicTagMapper comicTagMapper;

    @Autowired
    private CartMapper cartMapper;


    @Override
    public PageResult getAllList(ComicListDTO comicListDTO) {

        PageHelper.startPage(comicListDTO.getPage(),comicListDTO.getPageSize());

        Page<Comic> page = (Page<Comic>) comicMapper.selectPage();

        return new PageResult(page.getTotal(),page.getResult());
    }


    @Override
    public PageResult searchList(SearchComicDTO searchComicDTO) {
        log.info("搜索,{}",searchComicDTO);

        PageHelper.startPage(searchComicDTO.getPage(),searchComicDTO.getPageSize());

        Page<Comic> page = (Page<Comic>) comicMapper.searchList(searchComicDTO);

        if(page.isEmpty()){
            return new PageResult(page.getTotal(), page.getResult());
        }

        List<Long> idlist = new ArrayList<>();
        for (Comic comic : page) {
            idlist.add(comic.getId());
        }

        //查询漫画标签
        List<TagComicDTO> list = tagMapper.selectListByIds(idlist);

        Map<Long, List<Tag>> map = new HashMap<>();

        for (TagComicDTO dto : list) {
            Tag tag = new Tag(dto.getId(),dto.getName());
            if (map.containsKey(dto.getComicId())) {
                map.get(dto.getComicId()).add(tag);
            }else{
                List<Tag> l = new ArrayList<>();
                l.add(tag);
                map.put(dto.getComicId(),l);
            }
        }

        for (Comic comic : page) {
            comic.setTagList(map.getOrDefault(comic.getId(), null));
        }

        return new PageResult(page.getTotal(), page.getResult());
    }


    @Override
    @Transactional
    public void insert(ComicInsertDTO comicInsertDTO) {
        Comic comic = new Comic();

        BeanUtils.copyProperties(comicInsertDTO,comic);
        comic.setState(0);

        comicMapper.insert(comic);

        if(comicInsertDTO.getTagList() != null && !comicInsertDTO.getTagList().isEmpty()){
            comicTagMapper.insertComicIdList(comic.getId(),comicInsertDTO.getTagList());
        }

        if(comicInsertDTO.getVolumeList() == null || comicInsertDTO.getVolumeList().isEmpty()){
            return;
        }

        comicInsertDTO.getVolumeList().forEach(cv->{
            cv.setComicId(comic.getId());
            cv.setState(0);
            cv.setScore(BigDecimal.valueOf(5));
            cv.setCreateTime(LocalDateTime.now());
            cv.setUpdateTime(LocalDateTime.now());
        });


        comicVolumeMapper.insertList(comicInsertDTO.getVolumeList());



    }


    @Override
    @Transactional
    public void delete(Long id) {
        comicMapper.delete(id);
        comicTagMapper.delete(id);
        comicVolumeMapper.deleteByComicId(id);
        cartMapper.deleteByComicId(id);
    }


    @Override
    public ComicTagVolumeVO getComicTagVolumeById(Long id) {
        ComicTagVolumeVO vo;
        vo = comicMapper.selectById(id);

        vo.setComicVolumeList(comicVolumeMapper.selectByComicId(id));

        vo.setTagList(tagMapper.selectByComicId(id));

        return vo;
    }

    @Override
    public void update(Comic comic) {
        comicMapper.update(comic);
    }
}
