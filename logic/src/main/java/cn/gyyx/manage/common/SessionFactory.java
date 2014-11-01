package cn.gyyx.manage.common;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * -------------------------------------------------------------------------
 * @版权所有：北京光宇在线科技有限责任公司
 * @项目名称：dal
 * @作者：liuyongzhi
 * @联系方式：liuyongzhi@gyyx.cn
 * @创建时间： 2014年10月29日 上午9:24:32
 * @版本号：
 * @本类主要用途描述：构建SqlSessionFactory类，产生SqlSessionFactory
 *-------------------------------------------------------------------------
 */
public class SessionFactory {

	private static SqlSessionFactory sqlSessionFactory = null;

	static {
		String resource = "cn/gyyx/manage/config/mybatis-config.xml";
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			if (sqlSessionFactory == null) {
				sqlSessionFactory = new SqlSessionFactoryBuilder()
						.build(reader);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年10月29日
	 * @描述：通过调用getInstance方法返回SqlSessionFactory工厂
	 * @Title: getInstance 
	 * @Description: TODO
	 * @return SqlSessionFactory
	 */
	public static SqlSessionFactory getInstance() {
		return sqlSessionFactory;
	}
}
