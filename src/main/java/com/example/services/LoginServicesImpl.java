package com.example.services;

import com.example.dao.LoginDao;
import com.example.pojo.AccountInfo;
import com.example.pojo.LoginRecord;
import com.example.pojo.UserInfo;
import com.example.utils.MD5EncryptionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.Date;

/**
 * Created by liuquan on 2017/6/26.
 */
@Service
public class LoginServicesImpl implements LoginServices {

    @Autowired
    private LoginDao loginDao;


    public String validateUserLogin(String account, String pwd) {
        AccountInfo accountInfo = (AccountInfo) loginDao.queryUniqueAccountInfoByHQL(account);
        String userPwd = accountInfo.getPwd();
        String loginPwd = MD5EncryptionUtil.getEncryptionContentForMD5(pwd);
        String userID = null;
        if (pwd != null && pwd.equals(userPwd)) {
            UserInfo userInfo = accountInfo.getUserInfoByUserId();
            userID = userInfo.getUserId();
        }

        return userID;
    }

    public void addLoginRecord(String userID,String loginIP,String loginResult){
        LoginRecord loginRecord = new LoginRecord();
        loginRecord.setUserID(userID);
        loginRecord.setLoginIp(loginIP);
        loginRecord.setLoginResult(loginResult);
        loginRecord.setLoginTime(new Timestamp((new Date()).getTime()));
    }

}
