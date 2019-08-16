
package com.arthur.web.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MvcConfiguration implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //替换index空跳转(即直接跳转到页面没有任何业务逻辑)
        registry.addViewController("/").setViewName("forward:/member/index");
 
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
 
        WebMvcConfigurer.super.addViewControllers(registry);
 
    }
}
 