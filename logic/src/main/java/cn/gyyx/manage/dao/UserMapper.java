package cn.gyyx.manage.dao;

import cn.gyyx.manage.base.BaseMapper;
import cn.gyyx.manage.beans.UserBean;

/**
 * -------------------------------------------------------------------------
 * @版权所有：北京光宇在线科技有限责任公司
 * @项目名称：dal
 * @作者：liuyongzhi
 * @联系方式：liuyongzhi@gyyx.cn
 * @创建时间： 2014年10月29日 上午11:24:57
 * @版本号：
 * @本类主要用途描述：用户信息映射接口类
 *-------------------------------------------------------------------------
 */
public interface UserMapper extends BaseMapper<UserBean> {

	/**
	 * 
	 * @日期：2014年10月29日
	 * @描述：向us_user_tb中插入数据
	 * @Title: insertUser 
	 * @Description: TODO 
	 * @param user 用户实体类
	 * @return Boolean
	 */
	public Boolean insertUser(UserBean user);
	
	/**
	 * 
	 * @日期：2014年10月29日
	 * @描述：向us_userinfo_tb中插入数据
	 * @Title: insertUserInfo 
	 * @Description: TODO 
	 * @param user 用户实体类
	 * @return Boolean
	 */
	public Boolean insertUserInfo(UserBean user);
	
	/**
	 * 
	 * @日期：2014年10月29日
	 * @描述：更新表us_user_tb中的数据
	 * @Title: updateUser 
	 * @Description: TODO 
	 * @param user 用户实体类
	 * @return Boolean
	 */
	public Boolean updateUser(UserBean user);
	
	/**
	 * 
	 * @日期：2014年10月29日
	 * @描述：更新表us_userinfo_tb中的数据
	 * @Title: updateUserInfo 
	 * @Description: TODO 
	 * @param user 用户实体类
	 * @return Boolean
	 */
	public Boolean updateUserInfo(UserBean user);
	
	/**
	 * 
	 * @日期：2014年10月29日
	 * @描述：删除用户表中的信息
	 * @Title: deleteUser 
	 * @Description: TODO 
	 * @param user 用户实体类
	 * @return Boolean
	 */
	public Boolean deleteUser(UserBean user);
	
	/**
	 * 
	 * @日期：2014年10月29日
	 * @描述：输出用户详细信息表中的信息
	 * @Title: deleteUserInfo 
	 * @Description: TODO 
	 * @param user 用户实体类
	 * @return Boolean
	 */
	public Boolean deleteUserInfo(UserBean user);
	
	
}
