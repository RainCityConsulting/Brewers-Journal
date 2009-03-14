package com.rcc.brew.util;

public class DigestUtils {
    public static String digest(String s) {
        return org.apache.commons.codec.digest.DigestUtils.shaHex(s);
    }

    public static String createSalt() {
        return java.util.UUID.randomUUID().toString();
    }

    public static String encryptedPasswordDigest(String password, String salt) {
        return digest(salt + "--" + password);
    }

    public static String clearPasswordDigest(String clearPassword, String salt) {
        return digest(salt + "--" + digest(clearPassword));
    }
}   
