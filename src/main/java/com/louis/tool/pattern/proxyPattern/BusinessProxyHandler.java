package com.louis.tool.pattern.proxyPattern;

/**
 * 业务代理类，提供接口
 * 
 * @author Louis Tao
 *
 */
public class BusinessProxyHandler implements BusinessAction {

	private BusinessAction ba;

	public BusinessProxyHandler(BusinessAction ba) {
		this.ba = ba;
	}

	@Override
	public void businessA(String customer) {
		ba.businessA(customer);
	}

	@Override
	public void businessB(String customer) {
		ba.businessB(customer);
	}

}
