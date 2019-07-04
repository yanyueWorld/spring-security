package com.study.demo.dao;

import com.study.demo.pojo.Account;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface AccountDao {
    int deleteByPrimaryKey(Integer id);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Account record);

    int updateByPrimaryKey(Account record);

    Account selectByUsername(String username);
}