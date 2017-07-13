package com.louis.tool.pattern.proxyPattern;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 使用JDK创建动态代理，需要实现特定的接口
 * 
 * @author Louis Tao
 *
 */
public class DynamicJDKBusinessProxyHandler implements InvocationHandler {

	private BusinessAction ba;

	public DynamicJDKBusinessProxyHandler(BusinessAction ba) {
		this.ba = ba;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		return method.invoke(ba, args);
	}

}
