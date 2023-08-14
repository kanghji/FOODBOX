//package com.groupfour.foodbox.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.csrf.CsrfFilter;
//import org.springframework.web.filter.CharacterEncodingFilter;
//
//public class SecurityInitializer extends WebSecurityConfigurerAdapter {
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
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
//
//        return new BCryptPasswordEncoder();
//    }
//}
