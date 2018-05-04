package com.cxy.model;

import java.util.Date;

/**
 * @author chengxy
 * @date 2018/5/3 13:44
 */
public class SupportCollege {

    private Long id;

    /**
     * 被赞大学
     * */
    private String whichCollege;

    /**
     * 赞数量
     * */
    private int supportNum;

    /**
     * 点赞人
     * */
    private Long userIdOfSupport;

    /**
     * 点赞时间
     * */
    private Date supportTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWhichCollege() {
        return whichCollege;
    }

    public void setWhichCollege(String whichCollege) {
        this.whichCollege = whichCollege;
    }

    public int getSupportNum() {
        return supportNum;
    }

    public void setSupportNum(int supportNum) {
        this.supportNum = supportNum;
    }

    public Date getSupportTime() {
        return supportTime;
    }

    public void setSupportTime(Date supportTime) {
        this.supportTime = supportTime;
    }

    public Long getUserIdOfSupport() {
        return userIdOfSupport;
    }

    public void setUserIdOfSupport(Long userIdOfSupport) {
        this.userIdOfSupport = userIdOfSupport;
    }

    @Override
    public String toString() {
        return "SupportCollege{" +
                "id=" + id +
                ", whichCollege='" + whichCollege + '\'' +
                ", supportNum=" + supportNum +
                ", userIdOfSupport=" + userIdOfSupport +
                ", supportTime=" + supportTime +
                '}';
    }
}
