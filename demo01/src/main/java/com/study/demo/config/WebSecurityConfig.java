package com.study.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * WebSecurityConfig.
 *
 * @author yanyue, 2019/7/2
 * @version spring-security v1.0
 */
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 重载配置方法
     *
     * @param httpSecurity
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                //允许基于HttpServletRequest限制访问
                .authorizeRequests()
                //配置url拦截，通过角色来拦截，也可以通过权限来拦截，permitAll()允许直接访问，hasAnyRole()，满足一个角色即可，hasRole()一个角色匹配
                .antMatchers("/").permitAll()
                .antMatchers("/user/**").hasAnyRole("admin", "user")
                .antMatchers("/admin/**").hasRole("admin")
                //拼接参数，类似于</>
                .and()
                //登录配置
                .formLogin().loginPage("/login").defaultSuccessUrl("/index")
                .and()
                //注销配置
                .logout().logoutUrl("/logout").logoutSuccessUrl("/login");
    }

    @Bean
    @Override
    protected UserDetailsService userDetailsService() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        UserDetails userDetails = User.withUsername("admin").password(encoder.encode("admin")).roles("admin").build();
        UserDetails userDetails1 = User.withUsername("user").password(encoder.encode("user")).roles("user").build();
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(userDetails);
        manager.createUser(userDetails1);
        return manager;
    }
}
