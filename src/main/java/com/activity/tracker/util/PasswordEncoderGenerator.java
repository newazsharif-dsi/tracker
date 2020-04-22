/*
 * Copyright (c) 2017 UniInfoSys. All Rights Reserved.
 */

package com.activity.tracker.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.security.SecureRandom;


public class PasswordEncoderGenerator {
    private static final String DEFAULT_PASSWORD = "12345@12345*#";
    public static String encodePassword(String password) {

        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String hashedPassword = passwordEncoder.encode(password);
        return hashedPassword;
    }


}
