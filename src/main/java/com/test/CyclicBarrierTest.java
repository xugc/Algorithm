/**
 * @Title: CyclicBarrierTest.java
 * @Package com.test
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-2-29 下午3:37:59
 * @version V1.0
 */
package com.test;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName: CyclicBarrierTest
 * @Description: TODO
 * @author 徐故成
 * @date 2016-2-29 下午3:37:59
 * 
 */
public class CyclicBarrierTest {

	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param args
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		final CyclicBarrier cb = new CyclicBarrier(3);
		class TestThread implements Runnable {
			CyclicBarrier cb;

			public TestThread(CyclicBarrier cb) {
				this.cb = cb;
			}

			@Override
			public void run() {
				try {
					System.out.println("执行");
					Thread.sleep(3000);
					System.out.println("结束");
					cb.await();
					System.out.println("go on");
				} catch (InterruptedException e) {
				} catch (BrokenBarrierException e) {
				}
			}

		}
		for(int i=0;i<3;i++){
			new Thread(new TestThread(cb)).start();
		}
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i=0;i<3;i++){
			new Thread(new TestThread(cb)).start();
		}

	}

}
