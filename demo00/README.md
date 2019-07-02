#spring-security 入门
1. 默认用户名为user 密码为项目启动时生成
2. spring-security有默认的登录页面，其具体设置请看api
3. 查看api可以知道在org.springframework.security.config.annotation.web.builders这个包里面，有个HttpSecurity，里面的formLogin()方法指定了登录页面的路径，在formLogin()方法介绍里面，提到了FormLoginConfigurer.loginPage(String)方法，进而看该方法的介绍，可以看到默认的登录页面加载就是该方法。