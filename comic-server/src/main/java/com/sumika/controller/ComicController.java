package com.sumika.controller;

import com.sumika.dto.ComicInsertDTO;
import com.sumika.dto.ComicListDTO;
import com.sumika.dto.SearchComicDTO;
import com.sumika.entity.Comic;
import com.sumika.result.PageResult;
import com.sumika.result.Result;
import com.sumika.service.ComicService;
import com.sumika.vo.ComicTagVolumeVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-20 14:48
 */

@RestController
@RequestMapping("/comic")
@Slf4j
@CrossOrigin
public class ComicController {


    @Autowired
    private ComicService comicService;


    @GetMapping("/comiclist")
    public Result<PageResult> getlist(ComicListDTO comicListDTO){
        log.info("分页查询,{}",comicListDTO);
        return Result.success(comicService.getAllList(comicListDTO));
    }

    @GetMapping("/{id}")
    public Result<ComicTagVolumeVO> getComicTagVolumeById(@PathVariable Long id){

        return Result.success(comicService.getComicTagVolumeById(id));
    }


    @GetMapping("/searchcomiclist")
    public Result<PageResult> searchComiclist(SearchComicDTO searchComicDTO){
        log.info("分页查询,{}",searchComicDTO);

        return Result.success(comicService.searchList(searchComicDTO));
    }

    @PutMapping
    public Result insert(@RequestBody ComicInsertDTO comicInsertDTO){
        log.info("comicdto,{}",comicInsertDTO);
        comicService.insert(comicInsertDTO);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        comicService.delete(id);
        return Result.success();
    }

    @PostMapping
    public Result update(@RequestBody Comic comic){
        comicService.update(comic);
        return Result.success();
    }

}
