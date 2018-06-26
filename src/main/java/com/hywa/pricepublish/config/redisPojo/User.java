package com.hywa.pricepublish.config.redisPojo;
import java.io.Serializable;
import java.util.Date;


/**
 * 获取当前登录用户信息类
 * */
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	//用户ID
	private String id;
    //用户登录名称
	private String cname;
    //用户编码
	private String ccode;

	private String cstatus;

	private String createuser;
	
	private String  createdate;

	private String updateuser;
	
	private String updatedate;

	private String cver;

	private String realName;

	private String password;

	private String photo;

	private int sex;

	private String refSysDepartment;

	private String refPj;

	private String refZhccSRole;

	private String phone;

	private String weixin;

	private String qq;

	private String email;

	private String idCard;

	private Date birthday;

	private Integer height;

	private Float weight;

	private String nativePlace;

	private Integer nation;

	private String currAddress;

	private String loginIp;

	private Date loginDate;

	private Long loginCount;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getCcode() {
		return ccode;
	}

	public void setCcode(String ccode) {
		this.ccode = ccode;
	}

	public String getCstatus() {
		return cstatus;
	}

	public void setCstatus(String cstatus) {
		this.cstatus = cstatus;
	}

	public String getCreateuser() {
		return createuser;
	}

	public void setCreateuser(String createuser) {
		this.createuser = createuser;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getUpdateuser() {
		return updateuser;
	}

	public void setUpdateuser(String updateuser) {
		this.updateuser = updateuser;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public String getCver() {
		return cver;
	}

	public void setCver(String cver) {
		this.cver = cver;
	}

	public String getRealName() {
		return realName;
	}

	public void setRealName(String realName) {
		this.realName = realName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public String getRefSysDepartment() {
		return refSysDepartment;
	}

	public void setRefSysDepartment(String refSysDepartment) {
		this.refSysDepartment = refSysDepartment;
	}

	public String getRefPj() {
		return refPj;
	}

	public void setRefPj(String refPj) {
		this.refPj = refPj;
	}

	public String getRefZhccSRole() {
		return refZhccSRole;
	}

	public void setRefZhccSRole(String refZhccSRole) {
		this.refZhccSRole = refZhccSRole;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWeixin() {
		return weixin;
	}

	public void setWeixin(String weixin) {
		this.weixin = weixin;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Integer getHeight() {
		return height;
	}

	public void setHeight(Integer height) {
		this.height = height;
	}

	public Float getWeight() {
		return weight;
	}

	public void setWeight(Float weight) {
		this.weight = weight;
	}

	public String getNativePlace() {
		return nativePlace;
	}

	public void setNativePlace(String nativePlace) {
		this.nativePlace = nativePlace;
	}

	public Integer getNation() {
		return nation;
	}

	public void setNation(Integer nation) {
		this.nation = nation;
	}

	public String getCurrAddress() {
		return currAddress;
	}

	public void setCurrAddress(String currAddress) {
		this.currAddress = currAddress;
	}

	public String getLoginIp() {
		return loginIp;
	}

	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}

	public Date getLoginDate() {
		return loginDate;
	}

	public void setLoginDate(Date loginDate) {
		this.loginDate = loginDate;
	}

	public Long getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(Long loginCount) {
		this.loginCount = loginCount;
	}

	public String getOrgId() {
		return orgId;
	}

	public void setOrgId(String orgId) {
		this.orgId = orgId;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getLogon() {
		return logon;
	}

	public void setLogon(String logon) {
		this.logon = logon;
	}

	private String orgId;
	
	private String deptId;
	
	/**
	 * 盘点当前登录用户的token值
	 */
	private String accessToken;
	/**
	 * 盘点当前登录用户的token值
	 */
	private String logon;

}