/**
 * @Title: TwoStackForQueue.java
 * @Package com.test
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-2-20 上午9:57:37
 * @version V1.0
 */
package com.test;

import java.util.Stack;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: TwoStackForQueue
 * @Description: TODO
 * @author 徐故成
 * @date 2016-2-20 上午9:57:37
 * 
 */
public class TwoStackForQueue {
	private Stack<Integer> firstStack;
	private Stack<Integer> secondStack;

	public TwoStackForQueue() {
		this.firstStack = new Stack<Integer>();
		this.secondStack = new Stack<Integer>();
	}

	public Integer pop() {
		if (secondStack.empty()) {
			while (!firstStack.empty()) {
				secondStack.push(firstStack.pop());
			}
		}
		return secondStack.pop();
	}

	public void push(Integer data) {
		firstStack.push(data);
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
		// TwoStackForQueue testQueue = new TwoStackForQueue();
		// testQueue.push(1);
		// testQueue.push(2);
		// System.out.println(testQueue.pop());
		// testQueue.push(3);
		// System.out.println(testQueue.pop());
		// testQueue.push(4);
		// testQueue.push(5);
		// System.out.println(testQueue.pop());
		// System.out.println(testQueue.pop());
		// System.out.println(testQueue.pop());
		// Thread t = new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// }
		//
		// });
		// t.start();
		// String a = new String("123");
		// String b = new String("123");
		// System.out.println(a == b);
		// System.out.println(a.equals(b));
		// ExecutorService excutor = new ThreadPoolExecutor(3, 3, 0L,
		// TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(3));
		// ExecutorService excutor = Executors.newFixedThreadPool(2);
		// final AtomicInteger count = new AtomicInteger();
		// count.getAndSet(0);
		// for (int i = 0; i < 8; i++)
		// excutor.submit(new Runnable() {
		// int s;
		//
		// @Override
		// public void run() {
		// s = count.getAndIncrement();
		// System.out.println("start:" + s);
		// try {
		// Thread.sleep(5000);
		// } catch (InterruptedException e) {
		// }
		// System.out.println("end:" + s);
		// }
		// });
		// System.out.println("all end");

		final String middle = new String("123");
		Thread t = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						synchronized (middle) {
							System.out.println("A");
							middle.notify();
							middle.wait(5000);
							System.out.println(".......");
						}
					} catch (InterruptedException e) {
					}
				}
			}

		});
		t.start();
		Thread t3 = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						synchronized (middle) {
							System.out.println("B");
							Thread.sleep(10000);
							middle.notify();
							middle.wait();
						}
					} catch (InterruptedException e) {
					}
				}
			}

		});
		t3.start();

		// final String synStr = new String("123456");
		// final String synStr2 = new String("123456");
		// Thread t1 = new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// try {
		// synchronized (synStr) {
		// System.out.println("1enter");
		// synStr.wait();
		// }
		// System.out.println("1end");
		// } catch (InterruptedException e) {
		// }
		// }
		//
		// });
		// t1.start();
		// Thread t2 = new Thread(new Runnable() {
		//
		// @Override
		// public void run() {
		// try {
		// Thread.sleep(5000);
		// synchronized (synStr) {
		// System.out.println("2enter");
		// synStr.notifyAll();
		// }
		// System.out.println("2end");
		// } catch (InterruptedException e) {
		// }
		// }
		//
		// });
		// t2.start();
		// System.out.println("end");
	}

}
