package com.example.services;

import com.example.pojo.AccountInfo;
import org.springframework.stereotype.Service;

/**
 * Created by liuquan on 2017/7/11.
 */
@Service
public interface RegisterService {
    public boolean createAccount(AccountInfo accountInfo);

    public void test();
}
