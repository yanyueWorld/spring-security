package com.study.demo.pojo;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * Table: user
 */
@Data
public class Account implements Serializable {
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

    private List<Role> roles;

    private static final long serialVersionUID = 1L;
}