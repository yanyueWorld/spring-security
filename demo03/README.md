#spring-security 自定义登录
1. 账号/密码: admin/admin
2. 自定义filter继承AbstractAuthenticationProcessingFilter，并且重写构造器和attemptAuthentication()方法
3. 在config(HttpSecurity http)方法中，使用了自定义filter的时候，角色的校验应该为hasAuthority()或者hasAnyAuthority()
4. hasAuthority()或者hasAnyAuthority()方法本质上是基于权限校验的，会更加适用于基于RBAC设计的数据库。
5. 