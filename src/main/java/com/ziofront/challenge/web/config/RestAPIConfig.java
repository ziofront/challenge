package com.ziofront.challenge.web.config;

import com.ziofront.challenge.web.interceptor.PlaceFindHistoryInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author jiho
 */
@Configuration
public class RestAPIConfig implements WebMvcConfigurer {

    @Autowired
    private PlaceFindHistoryInterceptor placeFindHistoryInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(placeFindHistoryInterceptor).addPathPatterns("/api/place/find*");

    }
}
