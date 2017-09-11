package com.louis.exercise.jvm.finalize;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class FinalizationObject {

	final static Logger logger = LoggerFactory.getLogger(FinalizationObject.class);

	@Override
	protected void finalize() throws Throwable {
		logger.info("函数finalize被调用。");
		super.finalize();
	}

}
