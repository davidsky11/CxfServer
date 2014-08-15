package com.kn.utils;

import java.lang.reflect.Method;

import org.springframework.aop.ThrowsAdvice;

/**
 * <p>Title: FSVM System</p>
 *	
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2013</p>
 *	
 * <p>Company:foxconn </p>
 *
 * @date 2013-2-22 下午3:23:57
 *
 * @author east
 * @version 1.0
 */
public class ExceptionHandler implements ThrowsAdvice{
	
	/**
	 * 
	 * @param method
	 * @param args
	 * @param target
	 * @param throwable
	 */
	public void afterThrowing(Method method,Object[] args,Object target,Exception throwable){
		System.out.println("产生异常的方法名称:"+method.getName());
		for(Object o:args){
			System.out.println("方法的参数:"+o.toString());
		}
		System.out.println("代理对象:"+target.getClass().getName());
		System.out.println("抛出的异常:"+throwable.getMessage()+">>>>>"+throwable.getCause());
		System.out.println("异常详细信息:"+throwable.fillInStackTrace());
	}
}
