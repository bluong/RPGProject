package com.nyte.core;

public abstract class Target {
	
	private Object target;
	
	public Target(Object o) {
		target = o;
	}
	
	public Object getTarget() {
		return target;
	}
}
