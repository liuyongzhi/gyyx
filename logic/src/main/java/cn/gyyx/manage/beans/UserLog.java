package cn.gyyx.manage.beans;

import java.io.Serializable;
import java.util.Date;

/**
 * -------------------------------------------------------------------------
 * @版权所有：北京光宇在线科技有限责任公司
 * @项目名称：logic
 * @作者：liuyongzhi
 * @联系方式：liuyongzhi@gyyx.cn
 * @创建时间： 2014年11月1日 下午3:26:15
 * @版本号：
 * @本类主要用途描述：用户登录日志
 *-------------------------------------------------------------------------
 */
public class UserLog implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//主键
	private Integer code;
	//用户Id编号
	private String userId;
	//用户登录时间
	private Date loginTime;
	//用户登录IP
	private String loginIp;
	
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
	
	public Date getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}
	
	public String getLoginIp() {
		return loginIp;
	}
	public void setLoginIp(String loginIp) {
		this.loginIp = loginIp;
	}
	
}
