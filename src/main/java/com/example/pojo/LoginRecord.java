package com.example.pojo;

import java.sql.Timestamp;

/**
 * Created by liuquan on 2017/7/11.
 */
public class LoginRecord {
    private int loginRecordId;
    private String loginIp;
    private Timestamp loginTime;
    private String loginResult;
    private String userID;

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public int getLoginRecordId() {
        return loginRecordId;
    }

    public void setLoginRecordId(int loginRecordId) {
        this.loginRecordId = loginRecordId;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public Timestamp getLoginTime() {
        return loginTime;
    }

    public void setLoginTime(Timestamp loginTime) {
        this.loginTime = loginTime;
    }

    public String getLoginResult() {
        return loginResult;
    }

    public void setLoginResult(String loginResult) {
        this.loginResult = loginResult;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginRecord that = (LoginRecord) o;

        if (loginRecordId != that.loginRecordId) return false;
        if (loginIp != null ? !loginIp.equals(that.loginIp) : that.loginIp != null) return false;
        if (loginTime != null ? !loginTime.equals(that.loginTime) : that.loginTime != null) return false;
        if (loginResult != null ? !loginResult.equals(that.loginResult) : that.loginResult != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = loginRecordId;
        result = 31 * result + (loginIp != null ? loginIp.hashCode() : 0);
        result = 31 * result + (loginTime != null ? loginTime.hashCode() : 0);
        result = 31 * result + (loginResult != null ? loginResult.hashCode() : 0);
        return result;
    }

}
