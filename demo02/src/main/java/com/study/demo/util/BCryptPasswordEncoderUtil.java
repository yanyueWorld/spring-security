package com.study.demo.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * BCryptPasswordEncoderUtil.
 *
 * @author yanyue, 2019/7/4
 * @version spring-security v1.0
 */
public class BCryptPasswordEncoderUtil {

    private BCryptPasswordEncoderUtil() {
    }

     /**
       * create 生成加密密文.
       * @param password
       * @return String
       */
    public static String create(String password) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encoderPassword = encoder.encode(password.trim());
        return encoderPassword;
    }
}
