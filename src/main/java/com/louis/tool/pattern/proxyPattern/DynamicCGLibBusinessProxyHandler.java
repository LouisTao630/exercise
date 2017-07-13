package com.louis.tool.pattern.proxyPattern;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class DynamicCGLibBusinessProxyHandler implements MethodInterceptor {

	private BusinessAction ba;

	public DynamicCGLibBusinessProxyHandler(BusinessAction ba) {
		this.ba = ba;
	}

	@Override
	public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
		return method.invoke(ba, args);
	}

}
