package com.lounwb.boot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.util.UrlPathHelper;

@Configuration
public class WebConfig /*implements WebMvcConfigurer*/ {

    @Bean
    public WebMvcConfigurer webMvcConfigurer(){
        return new WebMvcConfigurer() {
            @Override
            public void configurePathMatch(PathMatchConfigurer configurer) {
                UrlPathHelper helper = new UrlPathHelper();
                helper.setRemoveSemicolonContent(false);
                configurer.setUrlPathHelper(helper);
            }
        };
    }

   /* @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        UrlPathHelper helper = new UrlPathHelper();
        helper.setRemoveSemicolonContent(false);
        configurer.setUrlPathHelper(helper);
    }*/
}
