package com.study.demo.dao;

import com.study.demo.pojo.Role;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RoleDao {

    List<Role> getRolesByUserId(Integer userId);
}
