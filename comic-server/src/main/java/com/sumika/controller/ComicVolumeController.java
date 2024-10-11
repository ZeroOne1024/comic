package com.sumika.controller;

import com.sumika.entity.ComicVolume;
import com.sumika.result.Result;
import com.sumika.service.ComicVolumeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-20 23:50
 */

@RestController
@RequestMapping("/comicvolume")
@Slf4j
@CrossOrigin
public class ComicVolumeController {

    @Autowired
    private ComicVolumeService comicVolumeService;

    @GetMapping("/serial")
    public Result<List<ComicVolume>> serialNumberList(Integer comicId){
        return Result.success(comicVolumeService.serialNumberList(comicId));
    }

    @GetMapping("/{id}")
    public Result<List<ComicVolume>> getByComicId(@PathVariable Integer id){
        return Result.success(comicVolumeService.getByComicId(id));
    }

    @PostMapping
    public Result update(@RequestBody ComicVolume comicVolume){
        comicVolumeService.update(comicVolume);
        return Result.success();
    }

    @PutMapping
    public Result insert(@RequestBody ComicVolume comicVolume){
        System.out.println(comicVolume);
        comicVolumeService.insert(comicVolume);
        return Result.success();
    }


    @PutMapping("/lists")
    public Result insertList(@RequestBody ArrayList<ComicVolume> volumes){
        comicVolumeService.insertList(volumes);
        return Result.success();
    }

    @DeleteMapping("/{id}")
    public Result deleteById(@PathVariable Long id){

        comicVolumeService.deleteById(id);
        return Result.success();
    }

}
