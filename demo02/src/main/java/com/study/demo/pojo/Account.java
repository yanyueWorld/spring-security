package com.study.demo.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * Table: user
 */
@Data
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Table:     user
     * Column:    id
     * Nullable:  false
     */
    private Integer id;
    /**
     * Table:     user
     * Column:    username
     * Nullable:  false
     */
    private String username;
    /**
     * Table:     user
     * Column:    password
     * Nullable:  false
     */
    private String password;
    /**
     * roles 角色信息
     */
    private List<Role> roles;
}