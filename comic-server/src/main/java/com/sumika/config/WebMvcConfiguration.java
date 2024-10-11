package com.sumika.config;



import com.sumika.interceptor.CorsInterceptor;
import com.sumika.interceptor.JwtTokenInterceptor;
import com.sumika.json.JacksonObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;


import java.util.List;

/**
 * @author Asuka
 */
@Configuration
@Slf4j
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

    @Autowired
    private JwtTokenInterceptor jwtTokenInterceptor;

    @Autowired
    private CorsInterceptor corsInterceptor;



    @Override
    protected void addInterceptors(InterceptorRegistry registry){
        log.info("开始注册拦截器...");

        registry.addInterceptor(corsInterceptor).addPathPatterns("/**");

        registry.addInterceptor(jwtTokenInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/user/login")
                .excludePathPatterns("/user/register");


        log.info("拦截器注册完毕...");
    }




    @Override
    protected void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        log.info("开始注册消息转换器...");
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(new JacksonObjectMapper());
        converters.add(0,converter);
    }






    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /**
         * 访问路径：http://localhost:93/facereport/static/captured/daping_report/captured_images/face/788001414206074880/2021/1/27/cj_142207194912440320.png
         * "/facereport/static/captured/**" 为前端URL访问路径
         * "file:" + uploadPath 是本地磁盘映射
         */
        registry.addResourceHandler("/static/image/**").addResourceLocations("file:" + "image/");
    }


}
