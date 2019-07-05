package com.study.demo.config;

import com.study.demo.filter.CustomFilter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * WebSecurityConfig.
 *
 * @author yanyue, 2019/7/5
 * @version spring-security v1.0
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
     /**
       * configure web安全校验规则配置。
       * @param http
       * @throws Exception
       * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter
       */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll()
                .antMatchers("/admin/**").hasAuthority("admin")
                .and()
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login");

        //设置拦截器位置，addFilterAt，addFilterAfter,addFilterBefore三种方法
        http.addFilterAt(new CustomFilter("/login"), UsernamePasswordAuthenticationFilter.class);
    }
}
