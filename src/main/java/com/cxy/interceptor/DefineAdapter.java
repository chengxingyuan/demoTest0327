package com.cxy.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author chengxy
 * @date 2018/4/24 13:59
 */
@Configuration
public class DefineAdapter extends WebMvcConfigurerAdapter {
    //    @Autowired
//    public RoleInterceptor roleInterceptor;//用户角色拦截器
    @Autowired
    public AuthenticationInterceptor authenticationInterceptor;//用户登录拦截器

    //    @Autowired
//    MeidaRequestDataCustomArgumentResolver meidaRequestDataCustomArgumentResolver;//自定义参数绑定
//    //自定义参数绑定
//    @Override
//    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        super.addArgumentResolvers(argumentResolvers);
//        argumentResolvers.add(meidaRequestDataCustomArgumentResolver);
//    }
    //自定义拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//用户角色拦截器
//        registry.addInterceptor(roleInterceptor).
//                addPathPatterns("/**");
//用户登录拦截器
        registry.addInterceptor(authenticationInterceptor).
                addPathPatterns("/**");
        super.addInterceptors(registry);
    }
}
