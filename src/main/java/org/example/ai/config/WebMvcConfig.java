package org.example.ai.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    /**
     * 显式映射静态资源路径
     * 解决yml文件因新增/api路径导致knife4j找不到其静态资源问题
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // 1. 让 /api/webjars/** 能访问到 Knife4j 的静态资源
        registry.addResourceHandler("/api/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");

        // 2. 同时保留原始 /webjars/** 映射（兼容性）
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

    /**
     * 将 /api/doc.html 转发到内部的 /doc.html（该文件在 jar 包中）
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/api/doc.html")
                .setViewName("forward:/doc.html");
    }
}