package com.sumika.controller.common;

import com.sumika.constant.MessageConstant;
import com.sumika.properties.FileProoerties;
import com.sumika.result.Result;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-19 11:24
 */

@RestController
@Slf4j
@RequestMapping("/image")
@CrossOrigin
public class image {

    @Autowired
    private FileProoerties fileProoerties;

    @Value("${spring.server}")
    private String server;

    @PostMapping("/upload")
    public Result upload(MultipartFile file){
        log.info("文件上传,{}",file);
        try {
            //获取文件名
            String originalFilename = file.getOriginalFilename();
            //获取后缀名
            String fileFormat = originalFilename.substring(originalFilename.lastIndexOf("."));

            String fileName = UUID.randomUUID().toString() + fileFormat;



            String path = fileProoerties.getFilepath();

            //path = path.substring(1);

            String p = path+"\\"+fileName;
            file.transferTo(new File(p));

            return Result.success(fileName);
        } catch (IOException e) {
            log.info("文件上传失败,{}",e);
        }

        return Result.error(MessageConstant.UPLOAD_FAILED);
    }


    @GetMapping(value = "/{image}",
    produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE,MediaType.IMAGE_GIF_VALUE}
    )
    public byte[] getImage(@PathVariable String image, HttpServletResponse response) {

        File file = new File(fileProoerties.getFilepath()+"/"+image);

        try(FileInputStream fis = new FileInputStream(file)) {
            //final FileInputStream fos = new FileInputStream(file);
            byte[] b = fis.readAllBytes();

            return b;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }


    private InputStream getImgInputStream(String imgPath) throws FileNotFoundException {
        return new FileInputStream(new File(imgPath));
    }

}
