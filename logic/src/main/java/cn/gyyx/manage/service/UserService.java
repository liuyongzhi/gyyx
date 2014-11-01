package cn.gyyx.manage.service;

import cn.gyyx.manage.beans.User;
import cn.gyyx.manage.beans.UserLog;
import cn.gyyx.manage.bll.UserBLL;
import cn.gyyx.manage.bll.UserLogBLL;

/**
 * -------------------------------------------------------------------------
 * @版权所有：北京光宇在线科技有限责任公司
 * @项目名称：logic
 * @作者：liuyongzhi
 * @联系方式：liuyongzhi@gyyx.cn
 * @创建时间： 2014年11月1日 下午5:16:09
 * @版本号：
 * @本类主要用途描述：用户数据信息服务层
 *-------------------------------------------------------------------------
 */
public class UserService {
	private UserBLL userBLL=new UserBLL();
	private UserLogBLL userLogBLL=new UserLogBLL();
	
	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年11月1日
	 * @描述：用户注册向数据库中添加用户信息和向用户登录表中添加用户登陆信息
	 * @Title: regsiter 
	 * @Description: TODO 
	 * @param user 用户信息表
	 * @param ip 远程客户端ip地址
	 * @return Boolean 注册是否成功
	 */
	public String regsiter(User user, String ip) {
		String uuidStr=null;
		Boolean result = userBLL.insertUser(user);
		//判断是否插入成功,注册成功，则像用户登录表中插入登录信息并将用户信息保存至memcached中
		if (result) {
			UserLog userLog = new UserLog();
			userLog.setUserId(user.getUserId());
			userLog.setLoginIp(ip);
			result = userLogBLL.insertUserLog(userLog);
			uuidStr=userBLL.createUUID(user);
		}
		return uuidStr;
	}
	
	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年11月1日
	 * @描述：用户登录
	 * @Title: login
	 * @Description: TODO
	 * @param user
	 *            用户信息，主要是用户名和密码
	 * @param ip
	 *            远程客户端的Ip
	 * @param uuidStr
	 *            客户端保存的UUID值
	 * @return String
	 */
	public String login(User user, String ip, String uuidStr) {
		String uuidLogin = null;
		if (uuidStr == null) {
			if (user.getUserId() != null) {
				User userTemp = userBLL.getUserByUserId(user.getUserId());
				// 密码一致时，向用户登录表中添加登录信息
				if (userTemp.getPassword().equals(user.getPassword())) {
					UserLog userLog = new UserLog();
					userLog.setUserId(user.getUserId());
					userLog.setLoginIp(ip);
					userLogBLL.insertUserLog(userLog);
					uuidLogin = userBLL.createUUID(user);
				}
			}
		} else {
			if (userBLL.isExistUUID(uuidStr)) {
				uuidLogin = uuidStr;
			}
		}
		return uuidLogin;
	}
}
