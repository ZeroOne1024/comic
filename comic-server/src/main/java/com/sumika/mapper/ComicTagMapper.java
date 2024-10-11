package com.sumika.mapper;

import com.sumika.entity.ComicTag;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-26 03:28
 */

@Mapper
public interface ComicTagMapper {

    void insertComicIdList(Long id, List<Long> tagList);

    @Delete("delete from comic_tag where comic_id = #{id}")
    void delete(Long id);

    @Insert("insert comic_tag (comic_id, tag_id) VALUES (#{comicId},#{tagId})")
    void insert(ComicTag comicTag);

    @Delete("delete from comic_tag where comic_id = #{comicId} and tag_id = #{tagId}")
    void deleteByComicTagId(ComicTag comicTag);
}
