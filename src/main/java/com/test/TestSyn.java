/**
 * @Title: TestSyn.java
 * @Package com.test
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-2-25 上午11:46:45
 * @version V1.0
 */
package com.test;

/**
 * @ClassName: TestSyn
 * @Description: TODO
 * @author 徐故成
 * @date 2016-2-25 上午11:46:45
 * 
 */
public class TestSyn {

	public synchronized void synM1() {
		System.out.println("1");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public synchronized void synM2() {
		System.out.println("2");
	}

	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param args
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		final TestSyn s=new TestSyn();
		new Thread(new Runnable(){

			@Override
			public void run() {
				s.synM1();
			}
			
		}).start();
		new Thread(new Runnable(){
			
			@Override
			public void run() {
				s.synM2();
			}
			
		}).start();

	}

}
