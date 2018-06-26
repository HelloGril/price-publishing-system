package com.hywa.pricepublish.representation;

import com.hywa.pricepublish.common.enums.CommonEnum;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class UserRep implements Serializable {
    private static final long serialVersionUID = -4963266899668807475L;

    private String uid;

    @NotNull(message = "用户名不能为空")
    private String name;

    private String phone;

    private String sex;

    private String jobTitle;

    private String regionId;

    @NotNull(message = "工作单位不能为空")
    private String workUnit;

    @Min(value = 10, message = "年龄最小限制1")
    @Max(value = 100, message = "年龄最大限制100")
    private Integer age;

    @NotNull(message = "密码不能为空")
    private String pwd;

    public UserRep() {
    }

    public UserRep(String uid, String name, String phone,
                   short sex, String jobTitle, String workUnit,
                   Integer age, String regionId) {
        this.setUid(uid);
        this.setName(name);
        this.setPhone(phone);
        this.setSex(CommonEnum.getSex(sex));
        this.setJobTitle(jobTitle);
        this.setWorkUnit(workUnit);
        this.setAge(age);
        this.setRegionId(regionId);
    }

    public String getRegionId() {
        return regionId;
    }

    public void setRegionId(String regionId) {
        this.regionId = regionId;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getWorkUnit() {
        return workUnit;
    }

    public void setWorkUnit(String workUnit) {
        this.workUnit = workUnit;
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


