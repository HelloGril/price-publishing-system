

package com.hywa.pricepublish.representation;

import java.io.Serializable;

public class UserRep implements Serializable {
    private static final long serialVersionUID = -4963266899668807475L;
    private int age;
    private String uid;
    private String name;
    private String realName;
    private String phone;
    private String sex;
    private String jobTitle;

    public UserRep() {
    }

    public UserRep(String uid, String name, String realName, String phone, String sex, String jobTitle, int age) {
        this.setUid(uid);
        this.setName(name);
        this.setRealName(realName);
        this.setPhone(phone);
        this.setSex(sex);
        this.setJobTitle(jobTitle);
        this.setAge(age);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
}


