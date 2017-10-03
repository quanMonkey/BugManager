package com.example.pojo;

/**
 * Created by liuquan on 2017/7/11.
 */
public class AccountInfo {
    private int accountId;
    private String account;
    private String pwd;
    private UserInfo userInfoByUserId;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AccountInfo that = (AccountInfo) o;

        if (accountId != that.accountId) return false;
        if (account != null ? !account.equals(that.account) : that.account != null) return false;
        if (pwd != null ? !pwd.equals(that.pwd) : that.pwd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = accountId;
        result = 31 * result + (account != null ? account.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        return result;
    }

    public UserInfo getUserInfoByUserId() {
        return userInfoByUserId;
    }

    public void setUserInfoByUserId(UserInfo userInfoByUserId) {
        this.userInfoByUserId = userInfoByUserId;
    }
}
