package cn.gyyx.manage.beans;

import java.io.Serializable;

/**
 * -------------------------------------------------------------------------
 * 
 * @版权所有：北京光宇在线科技有限责任公司
 * @项目名称：dal
 * @作者：liuyongzhi
 * @联系方式：liuyongzhi@gyyx.cn
 * @创建时间： 2014年10月29日 上午10:02:27
 * @版本号：
 * @本类主要用途描述：用户实体类，对应数据库中的用户表 
 *                            ----------------------------------------------------
 *                            ---------------------
 */
public class User implements Serializable {
	private static final long serialVersionUID = 1L;
	// 用户code，自增
	private Integer code;
	// 用户编号，主键
	private String userId;
	// 用户名
	private String userName;
	// 密码
	private String password;
	// 是否关闭该用户，默认开通
	private Boolean isOpen;

	// 性别true代表男，false代表女；默认男
	private Boolean sex = true;
	// 年龄
	private Integer age = 0;
	// 电话号码
	private String phone = "";
	// 电子邮件地址
	private String email = "";
	// 用户备注信息
	private String info = "";

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsOpen() {
		return isOpen;
	}

	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}
}
