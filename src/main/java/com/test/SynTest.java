/**
 * @Title: SynTest.java
 * @Package com.test
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-2-29 下午3:20:29
 * @version V1.0
 */
package com.test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**  
 * @ClassName: SynTest  
 * @Description: TODO  
 * @author 徐故成 
 * @date 2016-2-29 下午3:20:29  
 *    
 */
public class SynTest {

	/**  
	 * @Title: main  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param args    设定文件  
	 * @return void    返回类型  
	 * @throws  
	 */
	public static void main(String[] args) {
		System.out.println("-----主线程开始-----");
		final CountDownLatch syn=new CountDownLatch(2);
		new Thread(new Runnable(){

			@Override
			public void run() {
				System.out.println("执行第一组线程");
				syn.countDown();
				System.out.println("执行第一组线程结束");
			}
			
		}).start();
		new Thread(new Runnable(){
			
			@Override
			public void run() {
				System.out.println("执行第二组线程");
				syn.countDown();
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("执行第二组线程结束");
			}
			
		}).start();
		try {
			syn.await(1,TimeUnit.SECONDS);
			System.out.println("主线程结束");
		} catch (InterruptedException e) {
		}
	}

}
