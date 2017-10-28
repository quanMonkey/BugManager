package com.example.services;

import com.example.dao.BaseDao;
import com.example.dao.RegisterDao;
import com.example.dao.TestDao;
import com.example.pojo.AccountInfo;
import com.example.pojo.Employee;
import com.example.pojo.SystemAccountStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

/**
 * Created by liuquan on 2017/7/11.
 */
@Service
public class RegisterServiceImpl implements RegisterService {

    @Autowired
    private BaseDao registerDao;
    @Autowired
    private TestDao testDao;


    public boolean createAccount(AccountInfo accountInfo) {
        String  userID = createUserID();
        accountInfo.getUserInfoByUserId().setUserId(userID);
        accountInfo.getUserInfoByUserId().setRegisterTime(new Timestamp(new Date().getTime()));
        SystemAccountStatus systemAccountStatus = (SystemAccountStatus) registerDao.getCurrentSession().get(SystemAccountStatus.class,1);
        accountInfo.getUserInfoByUserId().setSystemAccountStatusByStatusId(systemAccountStatus);
        registerDao.getCurrentSession().save(accountInfo.getUserInfoByUserId());
        registerDao.save(accountInfo);
        return false;
    }

    public void test(){
        Employee e = new Employee();
        e.setName("test");
        testDao.save(e);
    }


    /**
     * 创建用户ID
     * @return
     */
    private String createUserID(){
        return UUID.randomUUID().toString();
    }
}
