package com.kn.test;

public class Test {
	
	public static void main(String[] args) {
		A a = new A();
		System.out.println(a.add(a.a, a.b));
		System.out.println("-------------");
		
		B b = new B();
		b.test1();
		
		System.out.println("-------------");
		b.test2();
	}

}

class A {
		
	public int a = 1;
	public int b = 2;
	
	public int add(int a, int b) {
		System.out.println("class > m");
		return a+b;
	}
}



class B extends A {
	 
	public void test1() {
		System.out.println("test1");
	}
	
	public void test2() {
		A a = new A();
		System.out.println("class > B");
		System.out.println(a.add(a.a, a.b));
	}
}