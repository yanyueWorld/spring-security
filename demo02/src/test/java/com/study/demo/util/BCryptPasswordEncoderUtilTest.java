package com.study.demo.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * //TODO description end with .
 *
 * @author yanyue, 2019/7/4
 * @version Araf v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BCryptPasswordEncoderUtilTest {

    @Test
    public void create() {
        System.out.println(BCryptPasswordEncoderUtil.create("admin"));
        System.out.println(BCryptPasswordEncoderUtil.create("user"));
    }
}