package com.study.demo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * WebSecurityConfig .
 *
 * @author yanyue, 2019/7/3
 * @version spring-security v1.0
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 从UserDetailsService中，获取用户名，密码等信息。
     */
    @Autowired
    private UserDetailsService userDetailsService;

     /**
       * passwordEncoder 对密码加密.
       * @return BCryptPasswordEncoder 加密之后的结果
       */
    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }

     /**
       * configure 配置基于http请求的安全认证
       * @param httpSecurity
       * @throws Exception
       * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
       */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.
                authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/user/**").hasAnyRole("admin", "user")
                .antMatchers("/admin/**").hasRole("admin")
                .and()
                .formLogin().loginPage("/login").defaultSuccessUrl("/index")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login");
    }

     /**
       * configure,将userDetailsService的用户信息
       * @param builder
       * @throws Exception
       * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
       */
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
}
