package com.cxy.model;

import java.util.Date;

/**
 * @author chengxy
 * @date 2018/5/4 13:53
 */
public class SupportUser {
    private Long id;

    private int whichUser;

    private int supportNum;

    private int userIdOfSupport;

    private Date supportTime;

    @Override
    public String toString() {
        return "SupportUserImpl{" +
                "id=" + id +
                ", whichUser=" + whichUser +
                ", supportNum=" + supportNum +
                ", userIdOfSupport=" + userIdOfSupport +
                ", supportTime=" + supportTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getWhichUser() {
        return whichUser;
    }

    public void setWhichUser(int whichUser) {
        this.whichUser = whichUser;
    }

    public int getSupportNum() {
        return supportNum;
    }

    public void setSupportNum(int supportNum) {
        this.supportNum = supportNum;
    }

    public int getUserIdOfSupport() {
        return userIdOfSupport;
    }

    public void setUserIdOfSupport(int userIdOfSupport) {
        this.userIdOfSupport = userIdOfSupport;
    }

    public Date getSupportTime() {
        return supportTime;
    }

    public void setSupportTime(Date supportTime) {
        this.supportTime = supportTime;
    }
}
