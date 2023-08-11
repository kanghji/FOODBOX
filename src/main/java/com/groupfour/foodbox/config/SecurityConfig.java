//package com.groupfour.foodbox.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.csrf.CsrfFilter;
//import org.springframework.web.filter.CharacterEncodingFilter;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
////        super.configure(http);
////        http.csrf().disable();
//
//        // 한글 인코딩
//        CharacterEncodingFilter cef = new CharacterEncodingFilter();
//
//        cef.setEncoding("UTF-8");
//        cef.setForceEncoding(true);
//
//        http.addFilterBefore(cef, CsrfFilter.class);
//
//    }
//
//    @Bean
//    public PasswordEncoder getPasswordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//}
