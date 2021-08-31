package com.pp.security;

import java.security.MessageDigest;
import java.util.Base64;

/**
 * <pre>
 * Modify Information:
 * Author       Date          Description
 * ============ ============= ============================
 * liangpanpan   2021/8/19       create this file
 * </pre>
 */
public class SecurityUtils {

    public static final String DIGEST_ALGORITHM_MD5 = "MD5";

    public static byte[] digest(String message, String algorithm) throws Exception {
        MessageDigest md = MessageDigest.getInstance(algorithm);
        md.update(message.getBytes("UTF-8"));
        return md.digest();
    }

    /**
     * Hash the message with default algorithm "MD5".
     */
    public static byte[] digest(String message) throws Exception {
        return digest(message, DIGEST_ALGORITHM_MD5);
    }

    public static String bytes2hex(byte[] bytes) {
        StringBuilder result = new StringBuilder();
        String b = "";
        if (null == bytes) {
            return null;
        }
        for (int i = 0; i < bytes.length; i++) {
            b = Integer.toHexString(bytes[i] & 0xFF).toUpperCase();
            if (b.length() == 1) {
                b = "0" + b;
            }
            result.append(b);
        }
        return result.toString();
    }

    public static void main(String[] args) throws Exception {

        String message = "00-50-56-C0-00-01|9C-B6-D0-88-8A-3F|00-50-56-C0-00-08|";

        byte[] res = digest(message);
        System.out.println(bytes2hex(res));

        System.out.println(Base64.getEncoder().encodeToString(res));


    }

}
