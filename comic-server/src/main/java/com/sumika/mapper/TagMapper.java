package com.sumika.mapper;

import com.sumika.dto.TagComicDTO;
import com.sumika.entity.Tag;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-19 08:32
 */

@Mapper
public interface TagMapper {
    List<TagComicDTO> selectListByIds(List<Long> idlist);

    @Select("select id, name from tag")
    List<Tag> selectAll();

    List<Tag> selectByComicId(Long id);
}
