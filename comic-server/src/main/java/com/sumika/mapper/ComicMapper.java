package com.sumika.mapper;

import com.sumika.annotation.AutoFill;
import com.sumika.dto.SearchComicDTO;
import com.sumika.entity.Comic;
import com.sumika.enumeration.OperationType;
import com.sumika.vo.ComicTagVolumeVO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-20 15:51
 */

@Mapper
public interface ComicMapper {

    @Select("select * from comic")
    List<Comic> selectPage();

    List<Comic> searchList(SearchComicDTO searchComicDTO);

    @AutoFill(OperationType.INSERT)
    void insert(Comic comic);

    @Delete("delete from comic where id = #{id}")
    void delete(Long id);

    @Select("select * from comic where id =#{id}")
    ComicTagVolumeVO selectById(Long id);

    @AutoFill(OperationType.UPDATE)
    void update(Comic comic);
}
