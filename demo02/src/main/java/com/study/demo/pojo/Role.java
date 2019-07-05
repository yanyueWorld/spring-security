package com.study.demo.pojo;

import lombok.Data;

import java.io.Serializable;

/**
 * Table: role
 */
@Data
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Table:     role
     * Column:    id
     * Nullable:  false
     */
    private Integer id;
    /**
     * Table:     role
     * Column:    role_name
     * Nullable:  false
     */
    private String roleName;
}