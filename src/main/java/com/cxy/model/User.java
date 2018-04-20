package com.cxy.model;

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
}
