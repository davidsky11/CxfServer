package com.kn.utils;

public class LogPrint {
	
	public String printToTerm(String funcName, Object... strs) {
		
		String className = this.getClass().getName();
		String pStr = " >> " + className + " >> " + funcName + " >> " + "\n\t" + strs;
		
		return pStr;
	}
}
