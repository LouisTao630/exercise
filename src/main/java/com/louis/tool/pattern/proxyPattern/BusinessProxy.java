package com.louis.tool.pattern.proxyPattern;

/**
 * 业务代理类，提供接口
 * 
 * @author Louis Tao
 *
 */
public class BusinessProxy implements BusinessAction {

	private BusinessAction ba;

	public BusinessProxy(BusinessAction ba) {
		this.ba = ba;
	}

	@Override
	public void businessA(String customer) {

		// 模拟进行安全检查，如果不能通过安全检查就不进行业务。
		if (customer.equals("bad-man")) {
			System.out.println("No Access to request Business A.");
			return;
		}
		ba.businessA(customer);
	}

	@Override
	public void businessB(String customer) {
		writeLog(customer);
		ba.businessB(customer);
	}

	/**
	 * 模拟在调用真实业务之前记录日志的行为
	 * 
	 * @param customer
	 */
	private void writeLog(String customer) {
		System.out.println(customer + " requst Business B.");
	}

}
