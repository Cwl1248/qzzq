package com.cwl.qzzp.configurer;

import com.cwl.qzzp.Interceptor.JWTInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author
 * @date 2021/5/14 23:23
 **/
@Configuration
public class MyConfig extends WebMvcConfigurationSupport {

    /**
     *WebMvcConfigurationSupport之后，会导致默认配置被覆盖（无法访问静态资源），
     * 要访问静态资源需要重写addResourceHandlers方法,重新设置访问路径
     * @param registry
     */
    @Override
    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
        super.addResourceHandlers(registry);
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/resources/")
                .addResourceLocations("classpath:/static/")
                .addResourceLocations("classpath:/public/")
                .addResourceLocations("file:D:/qzzpImg/LOGO/");
    }

    /**
     * 设置拦截和放行的请求
     * @param registry
     */
    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(myInterceptor())
                .addPathPatterns("/collection/insertDelivery")
                .addPathPatterns("/collection/insertCollection");
    }

    /**
     * 将自定义的拦截器挂载到spring容器中，交给spring管理
     * @return
     */
    @Bean
    public JWTInterceptor myInterceptor(){
        return new JWTInterceptor();
    }
}
