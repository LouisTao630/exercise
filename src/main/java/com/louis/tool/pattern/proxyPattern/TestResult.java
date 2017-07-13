package com.louis.tool.pattern.proxyPattern;

import java.lang.reflect.Proxy;

import net.sf.cglib.proxy.Callback;
import net.sf.cglib.proxy.Enhancer;

public class TestResult {

	public static void main(String[] args) {

		// 真实的业务对象
		BusinessAction a = new Department();

		// 1. 使用普通类生成静态代理
		System.out.println("----- Normal Proxy Pattern -----");
		BusinessAction proxy = new BusinessProxyHandler(a);
		runBusinessTest(proxy);
		System.out.println();

		// 2. 使用JDK生成动态代理，必须针对接口
		System.out.println("----- Dynamic JDK Proxy -----");
		DynamicJDKBusinessProxyHandler jdkProxyHandler = new DynamicJDKBusinessProxyHandler(a);
		proxy = (BusinessAction) Proxy.newProxyInstance(TestResult.class.getClassLoader(),
				new Class[] { BusinessAction.class }, jdkProxyHandler);
		runBusinessTest(proxy);
		System.out.println();

		// 3. 使用CGLib 生成动态代理，不需要针对接口。
		System.out.println("----- Dynamic CGLib Proxy -----");
		Callback callback = new DynamicCGLibBusinessProxyHandler(a);
		proxy = (BusinessAction) Enhancer.create(Department.class, callback);
		runBusinessTest(proxy);
		System.out.println();

	}

	public static void runBusinessTest(BusinessAction proxy) {
		proxy.businessA("good-man");
		proxy.businessB("good-man");
		proxy.businessA("bad-man");
		proxy.businessB("bad-man");
	}

}
