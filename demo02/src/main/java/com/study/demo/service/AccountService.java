package com.study.demo.service;

import com.study.demo.pojo.Account;

/**
 * AccountService.
 *
 * @author yanyue, 2019/7/3
 * @version spring-security v1.0
 */
public interface AccountService {
    Account getUserByUsername(String username);
}
