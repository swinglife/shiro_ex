package org.swinglife.dao;

import java.util.List;

import org.hibernate.Query;

public interface BaseDao {

	/***
	 * 添加
	 */
	public void addObject(Object object);

	/***
	 * 查询满足条件 return list
	 */
	public List findAllByHQL(String hql);

	/***
	 * 查询满足条件的数据
	 * 
	 * @param hql
	 * @param args
	 * @return
	 */
	public List findAllByHQL(String hql, Object[] args);

	/***
	 * 查询满足条件的对象
	 */
	public Object findObjectByHQL(String hql);

	public Object findObjectByHQL(String hql, Object[] args);

	/***
	 * 查询满足条件的对象
	 */
	public Object findObjectBySQL(String sql);

	/***
	 * 分页查询 return list
	 */
	public List findPage(String hql, int page, int size);

	/***
	 * 分页查询 带占位符参数
	 * 
	 * @param hql
	 * @param page
	 * @param size
	 * @param args
	 * @return
	 */
	public List findPage(String hql, int page, int size, Object[] args);

	/***
	 * 删除对象
	 */
	public void delObject(Object object);

	/***
	 * 更新对象
	 */
	public void updateObject(Object object);

	/***
	 * 批量更新对象 return int
	 */
	public void updateObjectByHQL(String hql);

	public void updateObjectByHQL(String hql, Object[] params);

	/***
	 * 通过sql查询所有
	 * 
	 * @param sql
	 * @return
	 */
	public List findAllBySql(String sql);

}
