package cn.gyyx.manage.bll;

import java.util.List;

import cn.gyyx.manage.beans.UserLog;
import cn.gyyx.manage.dao.UserLogDao;

/**
 * -------------------------------------------------------------------------
 * @版权所有：北京光宇在线科技有限责任公司
 * @项目名称：logic
 * @作者：liuyongzhi
 * @联系方式：liuyongzhi@gyyx.cn
 * @创建时间： 2014年11月1日 下午4:47:36
 * @版本号：
 * @本类主要用途描述：用户登录日志逻辑层
 *-------------------------------------------------------------------------
 */
public class UserLogBLL {
	private UserLogDao userLogDao=new UserLogDao();
	
	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年11月1日
	 * @描述：得到所有用户的登录日志
	 * @Title: getAll 
	 * @Description: TODO 
	 * @return List<UserLog> 所有用户登录日志列表
	 */
	public List<UserLog> getAll(){
		return userLogDao.getAll();
	}
	
	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年11月1日
	 * @描述：向数据库中插入一条用户登录日志
	 * @Title: insertUserLog 
	 * @Description: TODO 
	 * @param userLog
	 * @return Boolean
	 */
	public Boolean insertUserLog(UserLog userLog){
		return userLogDao.insertUserLog(userLog);
	}
}
