#spring-security DB版
mysql5.7数据库，mybatis持久层框架，druid连接池
1. Spring-Security 5之后，处于安全性的考虑，  调整了PasswordEncoder的实现与使用策略，推荐使用BCryptPasswordEncoder，Pbkdf2PasswordEncoder，SCryptPasswordEncoder等
2. 另外，当时用数据库jdbc查询之后，不在使用内存的方式保存个人信息，我们需要重写configure(AuthenticationManagerBuilder auth)方法，改方法可以将AuthenticationManager作为一个Bean用于UserDetailsService。
3. 账户密码为:admin/admin;user/user,密码使用了BcryptPassswordEncoder加密。