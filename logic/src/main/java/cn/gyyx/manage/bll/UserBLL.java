package cn.gyyx.manage.bll;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

import net.rubyeye.xmemcached.MemcachedClient;
import net.rubyeye.xmemcached.exception.MemcachedException;
import cn.gyyx.manage.beans.User;
import cn.gyyx.manage.common.MemcachedManager;
import cn.gyyx.manage.dao.UserDao;

/**
 * -------------------------------------------------------------------------
 * @版权所有：北京光宇在线科技有限责任公司
 * @项目名称：logic
 * @作者：liuyongzhi
 * @联系方式：liuyongzhi@gyyx.cn
 * @创建时间： 2014年11月1日 下午4:22:18
 * @版本号：
 * @本类主要用途描述：用户逻辑层操作类
 *-------------------------------------------------------------------------
 */
public class UserBLL {
	private UserDao userDao=new UserDao();
	private MemcachedClient mcc=MemcachedManager.getInstance();
	
	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年11月1日
	 * @描述：获取所有用户信息
	 * @Title: getAll 
	 * @Description: TODO 
	 * @return List<User> 用户信息列表
	 */
	public List<User> getAll(){
		return userDao.getAll();
	}
	
	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年11月1日
	 * @描述：多用户查询用户信息
	 * @Title: getAllByArr
	 * @Description: TODO 
	 * @param userNameArr  用户名数组
	 * @return List<User> 多用户列表信息
	 */
	public List<User> getAllByArr(String[] userNameArr){
		return userDao.getAllByArr(userNameArr);
	}
	
	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年11月1日
	 * @描述：根据用户userId查询用户信息
	 * @Title: getUserByUserId 
	 * @Description: TODO 
	 * @param userId 用户userId
	 * @return User 用户信息类
	 */
	public User getUserByUserId(String userId) {
		User user = null;
		try {
			//从memcached中获取数据
			user = mcc.get("user" + userId);
			//memcached中没有该数据，从数据库中获取，保存至memcached中
			if (user == null) {
				user = userDao.getUserByUserId(userId);
				if (user != null) {
					mcc.add("user" + user.getUserId(), 0, user);
				}
			}
		} catch (TimeoutException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (MemcachedException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年11月1日
	 * @描述：向数据库中插入用户信息
	 * @Title: insertUser 
	 * @Description: TODO 
	 * @param user 用户信息类
	 * @return Boolean 是否插入成功
	 */
	public Boolean insertUser(User user) {
		Boolean result = false;
		try {
			// 判断该用户是否已注册,如果没注册则插入
			if (userDao.getUserByUserId(user.getUserId()) == null) {
				result = userDao.insertUser(user);
				// 插入成功则像memcached中缓存数据
				if (result) {
					mcc.add("user" + user.getUserId(), 0, user);
				}
			}
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年11月1日
	 * @描述：更新数据库中用户信息
	 * @Title: updateUser 
	 * @Description: TODO 
	 * @param user 用户信息类
	 * @return Boolean 是否更新成功
	 */
	public Boolean updateUser(User user) {
		Boolean result = false;
		try {
			result = userDao.updateUser(user);
			// 更新成功则像memcached中更新数据
			if (result) {
				mcc.replace("user" + user.getUserId(), 0, user);
			}
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年11月1日
	 * @描述：删除数据库中数据
	 * @Title: deleteUser 
	 * @Description: TODO 
	 * @param user 用户信息类
	 * @return Boolean 用户信息是否删除成功
	 */
	public Boolean deleteUser(User user) {
		Boolean result = false;
		try {
			result = userDao.deleteUser(user);
			// 删除成功则向memcached中删除数据
			if (result) {
				mcc.delete("user" + user.getUserId());
			}
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年11月1日
	 * @描述：随机生成一个UUID作为键，将user对象保存到memcached
	 * @Title: createUUID 
	 * @Description: TODO 
	 * @return String 返回UUID字符串
	 */
	public String createUUID(User user){
		String uuidStr=null;
		try {
			UUID uuid=UUID.randomUUID();
			mcc.add(uuid.toString(), 0, user);
			uuidStr=uuid.toString();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uuidStr;
	}
	
	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年11月1日
	 * @描述：判断uuidStr在memcached是否存在
	 * @Title: isExistUUID 
	 * @Description: TODO 
	 * @param uuidStr UUID字符串
	 * @return Boolean memcached是否存在UUID键值
	 */
	public Boolean isExistUUID(String uuidStr){
		Boolean result=false;
		try {
			User user=mcc.get(uuidStr);
			if(user!=null){
				result=true;
			}
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (MemcachedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
}
