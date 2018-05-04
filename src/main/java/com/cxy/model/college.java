package com.cxy.model;

/**
 * @author chengxy
 * @date 2018/4/18 15:16
 */
public class College {
    private int id;

    private String college;

    private String initial;

    private String famousPerson;

    private String description;

    private int supportNum;

    private int registerNum;

    public int getSupportNum() {
        return supportNum;
    }

    public void setSupportNum(int supportNum) {
        this.supportNum = supportNum;
    }

    public int getRegisterNum() {
        return registerNum;
    }

    public void setRegisterNum(int registerNum) {
        this.registerNum = registerNum;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getFamousPerson() {
        return famousPerson;
    }

    public void setFamousPerson(String famousPerson) {
        this.famousPerson = famousPerson;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEnglishName() {
        return englishName;
    }

    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    private String englishName;

    }
