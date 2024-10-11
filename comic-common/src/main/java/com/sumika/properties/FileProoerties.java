package com.sumika.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author: Asuka
 * @Description:
 * @create: 2024-06-19 11:33
 */

@Component
@ConfigurationProperties(prefix = "comic")
@Data
public class FileProoerties {

    private String filepath;



}
