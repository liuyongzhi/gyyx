package cn.gyyx.manage.base;

import java.util.List;
import java.util.Map;

/**
 * -------------------------------------------------------------------------
 * @版权所有：北京光宇在线科技有限责任公司
 * @项目名称：dal
 * @作者：liuyongzhi
 * @联系方式：liuyongzhi@gyyx.cn
 * @创建时间： 2014年10月29日 上午9:40:27
 * @版本号：@param <T>
 * @本类主要用途描述：所有Mapper类的基类，主要包括增、删、改、查
 *-------------------------------------------------------------------------
 */
public interface BaseMapper<T> {
	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年10月29日
	 * @描述：通过code值返回所需要的某条信息
	 * @Title: getObjectByCode 
	 * @Description: TODO 
	 * @param code 用户主键值
	 * @return T
	 */
	public T getObjectByUserId(String code);

	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年10月29日
	 * @描述：通过Map得到所需信息
	 * @Title: getObjectByMap 
	 * @Description: TODO 
	 * @param map 多值查询时使用Map保存信息
	 * @return List<T> 返回实体类列表
	 */
	public List<T> getAllByArr(String[] arr);
	
	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年10月29日
	 * @描述：得到数据库中某张表所有信息
	 * @Title: getAll 
	 * @Description: TODO 
	 * @return List<T> 所有信息列表
	 */
	public List<T> getAll();

	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年10月29日
	 * @描述：向数据库中插入一条数据
	 * @Title: insert 
	 * @Description: TODO 
	 * @param object 插入的对象
	 * @return boolean 插入成功返回true
	 */
	public boolean insert(T object);

	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年10月29日
	 * @描述：更新数据
	 * @Title: update 
	 * @Description: TODO 
	 * @param object 更新的实体类
	 * @return boolean 更新成功返回true
	 */
	public boolean update(T object);
	
	/**
	 * 
	 * @作者：liuyongzhi
	 * @日期：2014年10月29日
	 * @描述：根据对象删除对象
	 * @Title: delete 
	 * @Description: TODO 
	 * @param object 删除的实体类
	 * @return boolean 删除成功时返回true
	 */
	public boolean delete(T object);
}
