package com.louis.exercise.jvm.finalize;

class FinalizationObject {

	@Override
	protected void finalize() throws Throwable {
		System.out.println("FinalizationObject is finalized.");
		super.finalize();
	}

}
