package com.sumika.controller;

import com.sumika.entity.ComicTag;
import com.sumika.result.Result;
import com.sumika.service.ComicTagSevice;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-26 12:41
 */

@CrossOrigin
@RequestMapping("/comictag")
@RestController
@Slf4j
public class ComicTagController {

    @Autowired
    private ComicTagSevice comicTagSevice;

    @PutMapping
    public Result insert(@RequestBody ComicTag comicTag){

        comicTagSevice.insert(comicTag);

        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestBody ComicTag comicTag){
        log.info("comictag,{}",comicTag);
        comicTagSevice.delete(comicTag);

        return Result.success();
    }

}
