package com.sumika.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "comic.jwt")
@Data
public class JwtProperties {


    private String tokenKey;
    private Long tokenKeyOutTime;
    private String tokenName;


}
