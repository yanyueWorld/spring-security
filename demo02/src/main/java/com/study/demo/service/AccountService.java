package com.study.demo.service;

import com.study.demo.pojo.Account;

/**
 * AccountService.
 *
 * @author yanyue, 2019/7/3
 * @version spring-security v1.0
 */
public interface AccountService {
     /**
       * getUserByUsername 通过用户名获取用户对象
       * @param username 用户名
       * @return Account 用户对象
       */
    Account getUserByUsername(String username);
}
