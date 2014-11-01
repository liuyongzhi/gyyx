package cn.gyyx.manage.common;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.XMemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;

/**
 * -------------------------------------------------------------------------
 * 
 * @版权所有：北京光宇在线科技有限责任公司
 * @项目名称：bll
 * @作者：liuyongzhi
 * @联系方式：liuyongzhi@gyyx.cn
 * @创建时间： 2014年10月31日 下午12:06:13
 * @版本号：
 * @本类主要用途描述：将MemcachedClient实例化 
 *                               ------------------------------------------------
 *                               -------------------------
 */
public class MemcachedManager {
	private static MemcachedClient mcc;
	static {
		try {
			//设置Memcached所在主机的Ip地址
			String ip = "192.168.6.195";
			//memcached程序的端口号
			int port = 20000;
			if (mcc == null) {
				mcc = new XMemcachedClient(ip, port);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static MemcachedClient getInstance() {
		return mcc;
	}

}
