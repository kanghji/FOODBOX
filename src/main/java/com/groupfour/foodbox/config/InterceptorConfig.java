package com.groupfour.foodbox.config;

import com.groupfour.foodbox.interceptor.AdminLoginInterceptor;
import com.groupfour.foodbox.interceptor.UserInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    AdminLoginInterceptor adminLoginInterceptor;

    @Autowired
    UserInterceptor userInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(adminLoginInterceptor)
               .addPathPatterns("/admin/**")
//               .addPathPatterns("/admin/categoryList")
//               .addPathPatterns("/admin/recipe")
//               .addPathPatterns("/admin/productList")
               .excludePathPatterns("/admin/adminLogin");

        registry.addInterceptor(userInterceptor)
                .addPathPatterns("/user/**")
                .excludePathPatterns("/user/productPage/**")
                .excludePathPatterns("/user/productView/**")
                .excludePathPatterns("/user/recipe/**")
                .excludePathPatterns("/user/recipeView/**")
                .excludePathPatterns("/user/findId/**")
                .excludePathPatterns("/user/findPw/**")
                .excludePathPatterns("/user/userRegister/**")
                .excludePathPatterns("/user/userLogin");


    }

}
