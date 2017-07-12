package com.louis.tool.pattern.proxyPattern;

public class TestResult {

	public static void main(String[] args) {

		BusinessAction a = new Department();
		BusinessAction proxy = new BusinessProxy(a);
		
		//期望用户能够顺利进行业务，并且在Business B时记录调用日志。
		proxy.businessA("good-man");
		proxy.businessB("good-man");
		
		//期望用户在Business A时被拦截，并且在Business B时记录调用日志。
		proxy.businessA("bad-man");
		proxy.businessB("bad-man");

	}

}
