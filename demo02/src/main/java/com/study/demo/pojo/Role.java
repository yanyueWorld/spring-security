package com.study.demo.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * Table: role
 */
@Data
public class Role implements Serializable {
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

    private static final long serialVersionUID = 1L;
}