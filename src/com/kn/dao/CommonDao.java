package com.kn.dao;

import java.util.List;

public interface CommonDao<T>{
	 /**
	  * 将对象数据插入到数据库中
	  * @param obj
	  * @throws Exception
	  */
    void create(T obj) throws Exception;

    /**
     * 将对象数据更新到数据库中
     * @param obj
     * @throws Exception
     */
    void update(T obj) throws Exception;

    /**
     * 从数据库中删除对象数据
     * @param obj
     * @throws Exception
     */
    void delete(T obj) throws Exception;

    /**
	 * 通过id获取对象
     * @param clazz
     * @param id
     * @return
     * @throws Exception
     */
    T get(Class <? extends T> clazz,Object id) throws Exception;
    
    /**
     * 查询数据库中对象的所有数据生成对象集合
     * @param clazz
     * @return
     * @throws Exception
     */
    List<T> getAll(Class <? extends T> clazz) throws Exception;
}
