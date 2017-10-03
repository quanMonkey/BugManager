package com.example.pojo;

/**
 * Created by liuquan on 2017/7/11.
 */
public class SystemAccountStatus {
    private int statusId;
    private String statusName;
    private String statusComment;

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    }

    public String getStatusComment() {
        return statusComment;
    }

    public void setStatusComment(String statusComment) {
        this.statusComment = statusComment;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SystemAccountStatus that = (SystemAccountStatus) o;

        if (statusId != that.statusId) return false;
        if (statusName != null ? !statusName.equals(that.statusName) : that.statusName != null) return false;
        if (statusComment != null ? !statusComment.equals(that.statusComment) : that.statusComment != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = statusId;
        result = 31 * result + (statusName != null ? statusName.hashCode() : 0);
        result = 31 * result + (statusComment != null ? statusComment.hashCode() : 0);
        return result;
    }
}
