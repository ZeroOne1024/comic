package com.sumika.controller;

import com.sumika.entity.Tag;
import com.sumika.result.Result;
import com.sumika.service.TagService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-20 23:46
 */

@RestController
@RequestMapping("/tag")
@Slf4j
@CrossOrigin
public class TagController {


    @Autowired
    private TagService tagService;

    @GetMapping
    //@Cacheable(cacheNames = "tagAllListCache")
    public Result<List<Tag>> getTagList(){
        return Result.success(tagService.selectAll());
    }

    @GetMapping("/{id}")
    public Result<List<Tag>> getTagListByComicId(@PathVariable Long id){
        return Result.success(tagService.getTagListByComicId(id));
    }





}
