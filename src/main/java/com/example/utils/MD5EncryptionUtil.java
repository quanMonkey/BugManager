package com.example.utils;

import org.springframework.util.Base64Utils;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by liuquan on 2017/7/10.
 */
public class MD5EncryptionUtil {

    public static String getEncryptionContentForMD5(String originalContent){
        if(StringUtils.isEmpty(originalContent)){
            return "";
        }
        String encryptionContent = null;
        try {
            String md5Content = DigestUtils.md5DigestAsHex(originalContent.getBytes("utf-8"));
            int len= originalContent.length();
            StringBuilder sbd = new StringBuilder(100);
            sbd.append(md5Content);
            sbd.reverse().append(md5Content.length()).append(md5Content);
//            System.out.println(sbd.toString());
            encryptionContent = Base64Utils.encodeToString(sbd.toString().getBytes());
//            System.out.println(md5Content);
//            System.out.println(encryptionContent);
//            System.out.println(encryptionContent.length());
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            encryptionContent = null;
        } finally{
            return encryptionContent;
        }
    }

    /**
     * 用于测试
     * @param args
     */
    /*public static void main(String[] args){
        MD5EncryptionUtil encryptionUtil =  new MD5EncryptionUtil();
        encryptionUtil.getEncryptionContentForMD5("246adgwdV");
        encryptionUtil.getEncryptionContentForMD5("wer");
        encryptionUtil.getEncryptionContentForMD5("abcdefghigklmn");
//       encryptionUtil.getEncryptionContentForMD5("246adgwdV");
    }*/
}
