package com.arthur.web.core.config;

import com.baomidou.kisso.web.interceptor.SSOSpringInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.CacheControl;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/*
 * @ClassName WebConfig
 * @Description kisso的登录初始化
 * @Author liuhan
 * @Date 2019/8/2 13:37
 * @Version 1.0
 */

@ControllerAdvice
@Configuration
public class WebConfig implements WebMvcConfigurer {
    /**
     * @Author liuhan
     * @Description 重写添加拦截器方法并添加配置拦截器
     * @Date 2019/8/2 14:23
     * @Param
     * @Return
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        List<String> excludePaths =  new ArrayList<String>();
        excludePaths.add("/login");
        excludePaths.add("/imageCheck");

        // kisso 拦截器配置
        registry.addInterceptor(new SSOSpringInterceptor()).addPathPatterns("/**").excludePathPatterns(excludePaths);
    }

    //配置静态资源的映射
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**")//服务器请求路径
                .addResourceLocations("classpath:/static/**")//资源定位路径
                .setCacheControl(CacheControl.maxAge(1, TimeUnit.HOURS).cachePublic());
    }
}
