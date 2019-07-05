package com.study.demo.service.impl;

import com.study.demo.dao.AccountDao;
import com.study.demo.pojo.Account;
import com.study.demo.service.AccountService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * AccountServiceImpl.
 *
 * @author yanyue, 2019/7/3
 * @version spring-security v1.0
 */
@Service
public class AccountServiceImpl implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public Account getUserByUsername(String username) {
        if(username==null||username.length()==0){
            return null;
        }
        Account account=accountDao.selectByUsername(username);
        if(account==null) {
            return null;
        }
        return account;
    }
}
