package com.example.pojo;

import java.sql.Timestamp;

/**
 * Created by liuquan on 2017/7/11.
 */
public class UserInfo {
    private String userId;
    private String nickName;
    private String userName;
    private String tellPhone;
    private String address;
    private String sex;
    private Integer age;
    private Timestamp registerTime;
    private SystemAccountStatus systemAccountStatusByStatusId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTellPhone() {
        return tellPhone;
    }

    public void setTellPhone(String tellPhone) {
        this.tellPhone = tellPhone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Timestamp getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(Timestamp registerTime) {
        this.registerTime = registerTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserInfo userInfo = (UserInfo) o;

        if (userId != null ? !userId.equals(userInfo.userId) : userInfo.userId != null) return false;
        if (nickName != null ? !nickName.equals(userInfo.nickName) : userInfo.nickName != null) return false;
        if (userName != null ? !userName.equals(userInfo.userName) : userInfo.userName != null) return false;
        if (tellPhone != null ? !tellPhone.equals(userInfo.tellPhone) : userInfo.tellPhone != null) return false;
        if (address != null ? !address.equals(userInfo.address) : userInfo.address != null) return false;
        if (sex != null ? !sex.equals(userInfo.sex) : userInfo.sex != null) return false;
        if (age != null ? !age.equals(userInfo.age) : userInfo.age != null) return false;
        if (registerTime != null ? !registerTime.equals(userInfo.registerTime) : userInfo.registerTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = userId != null ? userId.hashCode() : 0;
        result = 31 * result + (nickName != null ? nickName.hashCode() : 0);
        result = 31 * result + (userName != null ? userName.hashCode() : 0);
        result = 31 * result + (tellPhone != null ? tellPhone.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        result = 31 * result + (sex != null ? sex.hashCode() : 0);
        result = 31 * result + (age != null ? age.hashCode() : 0);
        result = 31 * result + (registerTime != null ? registerTime.hashCode() : 0);
        return result;
    }

    public SystemAccountStatus getSystemAccountStatusByStatusId() {
        return systemAccountStatusByStatusId;
    }

    public void setSystemAccountStatusByStatusId(SystemAccountStatus systemAccountStatusByStatusId) {
        this.systemAccountStatusByStatusId = systemAccountStatusByStatusId;
    }
}
