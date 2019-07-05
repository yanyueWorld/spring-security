package com.study.demo.dao;

import com.study.demo.pojo.Account;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface AccountDao {

    Account selectByPrimaryKey(Integer id);

    Account selectByUsername(String username);
}