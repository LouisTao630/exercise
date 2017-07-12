package com.louis.tool.pattern.proxyPattern;

/**
 * 实现代理模式的接口，代理类和被代理类都必须有相同的业务接口， 所以代理类和被代理类都需要继承业务方法接口。
 */
public interface BusinessAction {

	public void businessA(String customer);

	public void businessB(String customer);
}
