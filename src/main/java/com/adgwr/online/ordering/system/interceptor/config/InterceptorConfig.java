package com.adgwr.online.ordering.system.interceptor.config;

import com.adgwr.online.ordering.system.interceptor.ConstantsInterceptor;
import com.adgwr.online.ordering.system.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author Administrator
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ConstantsInterceptor()).
                addPathPatterns("/**").
                excludePathPatterns("/static/**");

        registry.addInterceptor(new LoginInterceptor()).
                addPathPatterns("/**").
                excludePathPatterns("/admin/**").
                excludePathPatterns("/bootstrap-3.3.7-dist/**").
                excludePathPatterns("/css/**").
                excludePathPatterns("/customer/**").
                excludePathPatterns("/fonts/**").
                excludePathPatterns("/foodImage/**").
                excludePathPatterns("/homeImage/**").
                excludePathPatterns("/images/**").
                excludePathPatterns("/js/**").
                excludePathPatterns("/logoImage/**").
                excludePathPatterns("/templets/**").
                excludePathPatterns("/7xw3we.com1.z0.glb.clouddn.com/**").
                excludePathPatterns("/uploads").excludePathPatterns("/error");
    }
}
