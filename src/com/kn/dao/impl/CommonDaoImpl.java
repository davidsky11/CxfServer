package com.kn.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.kn.dao.CommonDao;


public class CommonDaoImpl<T> implements CommonDao<T> {
	private HibernateTemplate hibernateTemplate;
	
	/**
	 * 
	 * @return
	 */
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	
	@Resource
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}

	/**
	 * 将对象数据obj插入到数据库中
	 */
	@Override
	public void create(T obj) throws Exception{
		hibernateTemplate.save(obj);
	}

	/**
	 * 将对象数据obj更新到数据库中
	 */
	@Override
	public void update(T obj) throws Exception{
		hibernateTemplate.update(obj);
	}

	/**
	 * 从数据库中删除对象数据
	 */
	@Override
	public void delete(T obj) throws Exception{
		hibernateTemplate.delete(obj);
	}

	/**
	 * 通过id获取对象
	 */
	@Override
	public T get(Class<? extends T> clazz, Object id) throws Exception{
		return (T) hibernateTemplate.get(clazz, (Serializable) id);
	}

	/**
	 * 查询数据库中对象的所有数据生成对象集合
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll(Class<? extends T> clazz) throws Exception{
		String hql = "from " +clazz.getSimpleName();
		return hibernateTemplate.find(hql);
	}
}
