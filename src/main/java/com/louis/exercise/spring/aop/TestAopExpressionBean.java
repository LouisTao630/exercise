package com.louis.exercise.spring.aop;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestAopExpressionBean {

	final static Logger logger = LoggerFactory.getLogger(TestAopExpressionBean.class);

	public void methodWithPublic() {
		logger.info("调用带有public修饰符的函数。");

		methodWithPrivate();
	}

	private void methodWithPrivate() {
		logger.info("调用带有private修饰符的函数。");
	}

	void methodWithoutModifier() {
		logger.info("调用带有沒有修饰符的函数。");
	}

	protected void methodWithProtected() {
		logger.info("调用带有protected修饰符的函数。");
	}

}
