package com.louis.tool.pattern.proxyPattern;

/**
 * 部门类是真正提供业务服务的对象，它实现了业务方法。
 * 
 * @author louistao
 *
 */
public class Department implements BusinessAction {

	@Override
	public void businessA(String customer) {
		System.out.println("Department will do business A for " + customer + "...Done.");
	}

	@Override
	public void businessB(String customer) {
		System.out.println("Department will do business B for " + customer + "...Done.");
	}

}
