package cn.gyyx.manage.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import cn.gyyx.manage.beans.UserLog;
import cn.gyyx.manage.common.SessionFactory;
import cn.gyyx.manage.mapper.UserLogMapper;

/**
 * -------------------------------------------------------------------------
 * @版权所有：北京光宇在线科技有限责任公司
 * @项目名称：logic
 * @作者：liuyongzhi
 * @联系方式：liuyongzhi@gyyx.cn
 * @创建时间： 2014年11月1日 下午4:39:47
 * @版本号：
 * @本类主要用途描述：用户登录数据层
 *-------------------------------------------------------------------------
 */
public class UserLogDao {
	
	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年11月1日
	 * @描述：得到所有用户的登录信息
	 * @Title: getAll 
	 * @Description: TODO 
	 * @return List<UserLog> 所有用户登录信息列表
	 */
	public List<UserLog> getAll(){
		SqlSession sqlSession = SessionFactory.getInstance().openSession();
		try {
			UserLogMapper userLogMapper = sqlSession.getMapper(UserLogMapper.class);
			return userLogMapper.getAll();
		} finally {
			sqlSession.close();
		}
	}
	
	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年11月1日
	 * @描述：向数据库中插入一条登录日志
	 * @Title: insertUserLog 
	 * @Description: TODO 
	 * @param userLog
	 * @return Boolean
	 */
	public Boolean insertUserLog(UserLog userLog){
		Boolean result=false;
		SqlSession sqlSession = SessionFactory.getInstance().openSession();
		try {
			UserLogMapper userLogMapper = sqlSession.getMapper(UserLogMapper.class);
			result=userLogMapper.insert(userLog);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}
		return result;
	}
}
