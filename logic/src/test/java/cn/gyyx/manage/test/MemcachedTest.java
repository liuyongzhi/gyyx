package cn.gyyx.manage.test;

import cn.gyyx.manage.dao.UserDao;
/**
 * -------------------------------------------------------------------------
 * 
 * @版权所有：北京光宇在线科技有限责任公司
 * @项目名称：bll
 * @作者：liuyongzhi
 * @联系方式：liuyongzhi@gyyx.cn
 * @创建时间： 2014年10月31日 下午12:25:11
 * @版本号：
 * @本类主要用途描述：Memcached测试类 
 *                        --------------------------------------------------------
 *                        -----------------
 */
public class MemcachedTest {

	public static void main(String[] args) {
		
		long start = System.currentTimeMillis();
		int count=20;
//		for (int i = 0; i < count; i++) {
//			//getUserByUserId使用了Memcached缓存
//			UserDao userService = new UserDao();
//			userService.getUserByUserId("18243086221");
//		}
		long end=System.currentTimeMillis();
		System.out.println("使用Memcached查询"+count+"次所用时间："+(end-start));
		start = System.currentTimeMillis();
//		for (int i = 0; i < count; i++) {
//			//getUserByUserId没有使用了Memcached缓存，每次从数据库中查询
//			UserDao userService = new UserDao();
//			userService.getUserByUserId1("18243086221");
//		}
		end=System.currentTimeMillis();
		System.out.println("不使用Memcached查询"+count+"次所用时间："+(end-start));
	}
}
