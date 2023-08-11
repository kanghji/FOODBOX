package com.groupfour.foodbox.config;

import com.groupfour.foodbox.interceptor.AdminLoginInterceptor;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.sql.DataSource;

@Component
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    AdminLoginInterceptor adminLoginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(adminLoginInterceptor)
              // .addPathPatterns("/**");
               .addPathPatterns("/admin/**")
//               .addPathPatterns("/admin/categoryList")
//               .addPathPatterns("/admin/recipe")
//               .addPathPatterns("/admin/productList")
               .excludePathPatterns("/admin/adminLogin");


    }

}
