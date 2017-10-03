package com.example.dao;

import com.example.pojo.AccountInfo;
import com.example.pojo.LoginRecord;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;

/**
 * Created by liuquan on 2017/7/7.
 */
@Repository
public class LoginDao extends BaseDao<AccountInfo> {

    /**
     * 根据账号获取该账号对应的账号信息
     *
     * @param account 登入账号
     * @return
     */
    public AccountInfo queryUniqueAccountInfoByHQL(String account) {
        Query query = getCurrentSession().createQuery("from AccountInfo where account=:account");
        query.setString("account", account);
        AccountInfo accountInfo = (AccountInfo) query.uniqueResult();
        return accountInfo;
    }

    public void insertLoginRecord(LoginRecord loginRecord) {
        getCurrentSession().save(loginRecord);
    }
}
