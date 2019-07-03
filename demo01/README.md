#spring-security
1. 在WebSecurityConfig中，重写了父类WebSecurityConfigurerAdapter的configure的方法，采用HttpSecurity参数。
2. 启用注解@EnableWebSecurity
3. /logout 404 该url需要使用post方法提交，因为spring security 默认开启了CSRF(Cross-site request forgery)，当然，可以通过代码实现在CSRF功能开启的情况下使用GET访问/logout,可以在WebSecurityConfig中，通过重写configure方法来调用logoutRequestMatcher()方法，类似于这样logoutRequestMatcher(new AntPathRequestMatcher(logoutUrl, “GET”)) 
#关于configure()方法说明
1. configure(AuthenticationManagerBuilder auth)  
AuthenticationManager()的默认实现用于尝试获取AuthenticationManager，如果被重载了，则需要指明哪一个AuthenticationManager.
2. configure(HttpSecurity http)  
此方法需要被重写，默认配置为：  
   http.authorizeRequests().anyRequest().authenticated().and().formLogin().and().httpBasic();
3. configure(WebSecurity web)  
此方法需要被重写，如果不需要url控制权限的话，就可以采用该方法。