package cn.gyyx.manage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import cn.gyyx.manage.beans.UserBean;
import cn.gyyx.manage.common.MybatisSessionFactory;

/**
 * -------------------------------------------------------------------------
 * 
 * @版权所有：北京光宇在线科技有限责任公司
 * @项目名称：logic
 * @作者：liuyongzhi
 * @联系方式：liuyongzhi@gyyx.cn
 * @创建时间： 2014年11月1日 下午3:52:35
 * @版本号：
 * @本类主要用途描述：用户数据库操作类 
 *                   ------------------------------------------------------------
 *                   -------------
 */
public class UserDao {
	Logger logger=Logger.getLogger(UserDao.class);
	
	/**
	 * 
	 * @日期：2014年11月1日
	 * @描述：得到用户列表
	 * @Title: getAll 
	 * @Description: TODO 
	 * @return List<User> 返回用户信息列表
	 */
	public List<UserBean> getAll() {
		logger.debug("得到所有用户信息！");
		SqlSession sqlSession = MybatisSessionFactory.getInstance().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			return userMapper.getAll();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * 
	 * @日期：2014年11月1日
	 * @描述：根据用户userId查询用户信息
	 * @Title: getUserByUserId 
	 * @Description: TODO 
	 * @param userId 用户的userId
	 * @return User userId对应的用户详细信息类
	 */
	public UserBean getUserByUserId(String userId){
		SqlSession sqlSession = MybatisSessionFactory.getInstance().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			return userMapper.getObjectByUserId(userId);
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * 
	 * @日期：2014年11月1日
	 * @描述：多用户名查询
	 * @Title: getAllByArr 
	 * @Description: TODO 
	 * @param arr 用户名数组
	 * @return List<User> 用户名数组对应的用户详细信息
	 */
	public List<UserBean> getAllByArr(String[] userNameArr){
		SqlSession sqlSession = MybatisSessionFactory.getInstance().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			return userMapper.getAllByArr(userNameArr);
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * 
	 * @日期：2014年11月1日
	 * @描述：向用户数据表和用户详细信息表中插入数据
	 * @Title: insertUser 
	 * @Description: TODO 
	 * @param user 用户信息类
	 * @return Boolean 是否插入成功
	 */
	public Boolean insertUser(UserBean user) {
		Boolean result=false;
		SqlSession sqlSession = MybatisSessionFactory.getInstance().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			result = userMapper.insertUser(user);
			result = userMapper.insertUserInfo(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	/**
	 * 
	 * @日期：2014年11月1日
	 * @描述：更新用户表和用户详细信息表中的数据
	 * @Title: updateUser 
	 * @Description: TODO 
	 * @param user 用户信息类
	 * @return Boolean 数据是否更新成功
	 */
	public Boolean updateUser(UserBean user) {
		Boolean result=false;
		SqlSession sqlSession = MybatisSessionFactory.getInstance().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			result = userMapper.updateUser(user);
			result = userMapper.updateUserInfo(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	/**
	 * 
	 * @日期：2014年11月1日
	 * @描述：删除用户表和用户详细信息表中的数据
	 * @Title: deleteUser 
	 * @Description: TODO 
	 * @param user 用户信息类
	 * @return Boolean 数据是否删除成功
	 */
	public Boolean deleteUser(UserBean user) {
		Boolean result=false;
		SqlSession sqlSession = MybatisSessionFactory.getInstance().openSession();
		try {
			UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
			result = userMapper.deleteUser(user);
			result = userMapper.deleteUserInfo(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return result;
	}
	
	
	

}
