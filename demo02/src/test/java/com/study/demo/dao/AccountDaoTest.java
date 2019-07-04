package com.study.demo.dao;

import com.study.demo.pojo.Account;
import lombok.extern.log4j.Log4j2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

/**
 * //TODO description end with .
 *
 * @author yanyue, 2019/7/3
 * @version Araf v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j2
public class AccountDaoTest {

    @Resource
    private AccountDao userDao;
    @Test
    public void selectByPrimaryKey() {
        Account account=userDao.selectByPrimaryKey(1);
        assertThat(account,notNullValue());
        log.info(account.toString());
    }

    @Test
    public void select(){
        System.out.println(userDao.selectByUsername("admin"));
    }
}
