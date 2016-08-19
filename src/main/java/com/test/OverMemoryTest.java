/**
 * @Title: OverMemoryTest.java
 * @Package com.test
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-2-29 下午2:15:32
 * @version V1.0
 */
package com.test;

/**
 * @ClassName: OverMemoryTest
 * @Description: TODO
 * @author 徐故成
 * @date 2016-2-29 下午2:15:32
 * 
 */
public class OverMemoryTest {
	public void test() {
		byte[][] o = new byte[18][];
		for(int i=0;i<17;i++){
			o[i] = new byte[15 * 1024 * 1024];
		}
		o[17] = new byte[15 * 1024 * 1024];
//		o1 = o;
//		o=o1;
//		byte[] o2 = new byte[300 * 1024 * 1024];
		System.out.println("method end");
	}
	public void test2() {
		byte[][] o = new byte[18][];
		for(int i=0;i<18;i++){
			o[i] = new byte[15 * 1024 * 1024];
		}
		
//		o1 = o;
//		o=o1;
//		byte[] o2 = new byte[300 * 1024 * 1024];
		System.out.println("method end");
	}

	public static void main(String[] args) {
		OverMemoryTest t = new OverMemoryTest();
		t.test();
//		byte[] o = new byte[150 * 1024 * 1024];
		byte[] o2 = new byte[17 * 1024 * 1024];
//		byte[] oo=new byte[15 * 1024 * 1024];
//		byte[] oo1=new byte[15 * 1024 * 1024];
		t.test2();
//		byte[] oo2=new byte[15 * 1024 * 1024];

		System.out.println("main end");
	}
}
