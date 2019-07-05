package com.study.demo.service.impl;

import com.study.demo.pojo.Account;
import com.study.demo.pojo.Role;
import com.study.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * UserDetailsServiceImpl.
 *
 * @author yanyue, 2019/7/3
 * @version spring-security v1.0
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountService accountService;

    /**
     * UserDetailsServiceImpl 构造器，初始化accountService.
     *
     * @param accountService
     */
    @Autowired
    UserDetailsServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    /**
     * 通过用户名加载用户对象.
     *
     * @param username 用户名
     * @return USerDetails 用户对象信息
     * @throws UsernameNotFoundException 用户名找不到异常
     * @see org.springframework.security.core.userdetails.UserDetailsService
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Account account = accountService.getUserByUsername(username);
        if (account == null) {
            throw new UsernameNotFoundException("用户名不存在！");
        }
        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        for (Role role : account.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        UserDetails userDetails = new User(account.getUsername(), account.getPassword(), authorities);
        return userDetails;
    }
}
