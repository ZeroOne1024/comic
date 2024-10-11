package com.sumika.mapper;

import com.sumika.annotation.AutoFill;
import com.sumika.entity.ComicVolume;
import com.sumika.enumeration.OperationType;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-19 08:32
 */

@Mapper
public interface ComicVolumeMapper {




    @Select("select * from comic_volume where comic_id = #{comicId} order by serial_number")
    List<ComicVolume> serialNumberList(Integer comicId);


    void insertList(List<ComicVolume> volumeList);

    @Delete("delete from comic_volume where comic_id = #{id}")
    void deleteByComicId(Long id);

    @Select("select * from comic_volume where comic_id = #{id} order by serial_number")
    List<ComicVolume> selectByComicId(Long id);

    void update(ComicVolume comicVolume);

    @Select("select * from comic_volume where comic_id = #{id} order by serial_number")
    List<ComicVolume> getByComicId(Integer id);

    @AutoFill(OperationType.INSERT)
    void insert(ComicVolume comicVolume);

    @Delete("delete from comic_volume where id = #{id}")
    void deleteById(Long id);
}
