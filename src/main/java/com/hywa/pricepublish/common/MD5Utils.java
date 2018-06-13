package com.hywa.pricepublish.common;

import com.hywa.pricepublish.common.exception.EncryptionOperationException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Utils {
    public static String md5(String encryptedObject) {
        try {
            char hexDigits[] = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(encryptedObject.getBytes());

            byte[] digest = md5.digest();
            int j = digest.length;
            char[] chars = new char[j * 2];
            int k = 0;
            for (int i = 0; i < j; i++) {
                byte byte0 = digest[i];
                chars[k++] = hexDigits[byte0 >>> 4 & 0xf];
                chars[k++] = hexDigits[byte0 & 0xf];
            }
            return new String(chars);
        }catch (Exception e){
            throw new EncryptionOperationException("加密操作失败");
        }


    }

}
