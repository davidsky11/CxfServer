package com.kn.test;

import org.junit.Test;

public class LogTest {
	
	public void test1() {
		
	}
	
	@Test
	public void test() {
		String classM = this.getClass().getName();
		String funcM = null;
		System.out.println(" >>> classN : " + classM + " >>> funcM : " + funcM);
	}

}
