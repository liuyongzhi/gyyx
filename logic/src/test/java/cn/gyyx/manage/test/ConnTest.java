package cn.gyyx.manage.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.gyyx.manage.beans.User;
import cn.gyyx.manage.common.SessionFactory;
import cn.gyyx.manage.mapper.UserMapper;

/**
 * -------------------------------------------------------------------------
 * @版权所有：北京光宇在线科技有限责任公司
 * @项目名称：dal
 * @作者：liuyongzhi
 * @联系方式：liuyongzhi@gyyx.cn
 * @创建时间： 2014年10月29日 上午10:19:28
 * @版本号：
 * @本类主要用途描述：测试类，测试数据库是否连接成功
 *-------------------------------------------------------------------------
 */
public class ConnTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory=new SessionFactory();
		SqlSessionFactory sqlSessionFactory=sessionFactory.getInstance();
		SqlSession sqlSession=sqlSessionFactory.openSession();
		UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
//		User user=new User();
//		user.setUserId("18243089550");
//		user.setUserName("liuyongzhi");
//		user.setPassword("liuyongzhi");
//		user.setIsOpen(true);
//		user.setPhone("18243089550");
//		user.setEmail("1685234@qq.com");
//		userMapper.updateUser(user);
//		userMapper.updateUserInfo(user);
//		userMapper.insert(user);
//		sqlSession.commit();
		
		List<User> userList=userMapper.getAll();
		for(User user:userList)
			System.out.println(user.getUserName());
		
	}
}
