package com.louis.exercise.jvm.finalize;

public class FinalizationObject {

	@Override
	protected void finalize() throws Throwable {
		System.out.println("This object  is finalized.");
		super.finalize();
	}

}
