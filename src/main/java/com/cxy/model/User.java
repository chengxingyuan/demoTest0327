package com.cxy.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author chengxy
 * @date 2018/4/19 11:26
 */
public class User {

    private Long id;

    /**
     * 昵称
     * */
    private String nickName;

    /**
     * 真实姓名
     * */
    private String realName;

    /**
     * 密码
     * */
    private String passWord;

    /**
     * 年龄
     * */
    private int age;

    /**
     * 性别 1.男, 0.女
     * */
    private int sex;

    /**
     * 所属大学
     * */
    private String university;

    /**
     * 关注
     * */
    private String attention;

    /**
     * 粉丝
     * */
    private String fans;

    /**
     * 获赞数
     * */
    private int support;

    /**
     * 电话
     * */
    private String phoneNum;

    /**
     * 现在城市
     * */
    private String liveCity;

    /**
     * 创建时间
     * */
    private Date createTime;

    /**
     * 用户注册时ip
     * */
    private String registerIp;

    /**
     * 用户id
     * */
    private Long userId;

    /**
     * 登录积分
     * */
    private int loginScore;

    /**
     * 付费获得的积分
     * */
    private int payScore;

    /**
     * 活动获得的积分
     * */
    private int activityScore;

    /**
     * 今日可用点赞数
     * */
    private int todayAvailableSupport;

    /**
     * 购买的可用点赞数
     * */
    private int payAvailableSupport;


    /**
     * 历史赞过数量
     * */
    private int historyUsedSupport;

    /**
     * vip过期时间
     * */
    private Date vipEndTime;

    /**
     * 历史消费金额
     * */
    private BigDecimal historyPayMoney;

    /**
     * 最后登录时间
     * */
    private Date lastLoginTime;

    /**
     * 最后登录时ip
     * */
    private String lastLoginIp;

    /**
     * 是否隐藏个人信息 0：不隐藏   1：隐藏
     * */
    private int hideSelfOrNot;

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    public int getHideSelfOrNot() {
        return hideSelfOrNot;
    }

    public void setHideSelfOrNot(int hideSelfOrNot) {
        this.hideSelfOrNot = hideSelfOrNot;
    }

    public int getLoginScore() {
        return loginScore;
    }

    public void setLoginScore(int loginScore) {
        this.loginScore = loginScore;
    }

    public int getPayScore() {
        return payScore;
    }

    public void setPayScore(int payScore) {
        this.payScore = payScore;
    }

    public int getActivityScore() {
        return activityScore;
    }

    public void setActivityScore(int activityScore) {
        this.activityScore = activityScore;
    }

    public int getTodayAvailableSupport() {
        return todayAvailableSupport;
    }

    public void setTodayAvailableSupport(int todayAvailableSupport) {
        this.todayAvailableSupport = todayAvailableSupport;
    }

    public int getPayAvailableSupport() {
        return payAvailableSupport;
    }

    public void setPayAvailableSupport(int payAvailableSupport) {
        this.payAvailableSupport = payAvailableSupport;
    }

    public int getHistoryUsedSupport() {
        return historyUsedSupport;
    }

    public void setHistoryUsedSupport(int historyUsedSupport) {
        this.historyUsedSupport = historyUsedSupport;
    }

    public Date getVipEndTime() {
        return vipEndTime;
    }

    public void setVipEndTime(Date vipEndTime) {
        this.vipEndTime = vipEndTime;
    }

    public BigDecimal getHistoryPayMoney() {
        return historyPayMoney;
    }

    public void setHistoryPayMoney(BigDecimal historyPayMoney) {
        this.historyPayMoney = historyPayMoney;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public int getSupport() {
        return support;
    }

    public void setSupport(int support) {
        this.support = support;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getAttention() {
        return attention;
    }

    public void setAttention(String attention) {
        this.attention = attention;
    }

    public String getFans() {
        return fans;
    }

    public void setFans(String fans) {
        this.fans = fans;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getLiveCity() {
        return liveCity;
    }

    public void setLiveCity(String liveCity) {
        this.liveCity = liveCity;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", nickName='" + nickName + '\'' +
                ", realName='" + realName + '\'' +
                ", passWord='" + passWord + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", university='" + university + '\'' +
                ", attention='" + attention + '\'' +
                ", fans='" + fans + '\'' +
                ", support=" + support +
                ", phoneNum='" + phoneNum + '\'' +
                ", liveCity='" + liveCity + '\'' +
                ", createTime=" + createTime +
                ", registerIp='" + registerIp + '\'' +
                ", userId=" + userId +
                '}';
    }
}
