package com.cxy.model;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author chengxy
 * @date 2018/4/26 16:30
 */
public class Article {
    private Long id;

    /**
     * 文章标题
     * */
    private String title;
    /**
     * 副标题
     * */
    private String littleTitle;
    /**
     * 作者
     * */
    private String author;
    /**
     * 正文
     * */
    private String context;
    /**
     * 作者自介绍
     * */
    private String aboutAuthor;
    /**
     * 好评数
     * */
    private int goodCommentNum;
    /**
     * 差评数
     * */
    private int badCommentNum;
    /**
     * 火力值
     * */
    private int hotScore;
    /**
     * 获得金钱
     * */
    private BigDecimal getMoney;
    /**
     * 发表时间
     * */
    private Date createTime;

    /**
     * 备注
     * */
    private String remark;

    /**
     * 最后更新时间
     * */
    private Date lastUpdateTime;

    /**
     * 文章所属高校
     * */
    private String belongCollege;

    /**
     * 文章所属专业
     * */
    private String belongMajor;

    public String getBelongCollege() {
        return belongCollege;
    }

    public void setBelongCollege(String belongCollege) {
        this.belongCollege = belongCollege;
    }

    public String getBelongMajor() {
        return belongMajor;
    }

    public void setBelongMajor(String belongMajor) {
        this.belongMajor = belongMajor;
    }

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", littleTitle='" + littleTitle + '\'' +
                ", author='" + author + '\'' +
                ", context='" + context + '\'' +
                ", aboutAuthor='" + aboutAuthor + '\'' +
                ", goodCommentNum=" + goodCommentNum +
                ", badCommentNum=" + badCommentNum +
                ", hotScore=" + hotScore +
                ", getMoney=" + getMoney +
                ", createTime=" + createTime +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLittleTitle() {
        return littleTitle;
    }

    public void setLittleTitle(String littleTitle) {
        this.littleTitle = littleTitle;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public String getAboutAuthor() {
        return aboutAuthor;
    }

    public void setAboutAuthor(String aboutAuthor) {
        this.aboutAuthor = aboutAuthor;
    }

    public int getGoodCommentNum() {
        return goodCommentNum;
    }

    public void setGoodCommentNum(int goodCommentNum) {
        this.goodCommentNum = goodCommentNum;
    }

    public int getBadCommentNum() {
        return badCommentNum;
    }

    public void setBadCommentNum(int badCommentNum) {
        this.badCommentNum = badCommentNum;
    }

    public int getHotScore() {
        return hotScore;
    }

    public void setHotScore(int hotScore) {
        this.hotScore = hotScore;
    }

    public BigDecimal getGetMoney() {
        return getMoney;
    }

    public void setGetMoney(BigDecimal getMoney) {
        this.getMoney = getMoney;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
