/**
 * @Title: FiveThinker.java
 * @Package com.test
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-2-22 下午12:41:24
 * @version V1.0
 */
package com.test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: FiveThinker
 * @Description: TODO
 * @author 徐故成
 * @date 2016-2-22 下午12:41:24
 * 
 */
public class FiveThinker implements Runnable {

	private int thinkerNum;
	private static Lock lock = new ReentrantLock();

	public FiveThinker(int number, Fork left, Fork right) {
		this.thinkerNum = number;
		this.left = left;
		this.right = right;
	}

	protected static class Fork {
		private volatile boolean state;// true拿起 false放下

		public Fork() {
			this.state = false;
		}

		public synchronized void takeUp() {
			while (state) {
				try {
					wait();
				} catch (InterruptedException e) {
				}
			}
			state = true;
		}

		public synchronized void putDown() {
			state = false;
			notifyAll();
		}
	}

	private Fork left;
	private Fork right;

	public void thinking() {
		System.out.println("思考家[" + thinkerNum + "]思考中......");
	}

	public void eat() {
		System.out.println("思考家[" + thinkerNum + "]吃饭");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
		}
	}

	@Override
	public void run() {
		while (true) {
			thinking();
			lock.lock();
			try {
				left.takeUp();
				Thread.sleep(5000);
				right.takeUp();
			} catch (InterruptedException e) {
				right.putDown();
				left.putDown();
			} finally {
				lock.unlock();
			}
			eat();
			right.putDown();
			left.putDown();
		}
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
		List<FiveThinker.Fork> forks = new ArrayList<FiveThinker.Fork>();
		ExecutorService excutor = Executors.newFixedThreadPool(5);

		// for (int i = 0; i < 5; i++) {
		// FiveThinker.Fork fork = new FiveThinker.Fork();
		// forks.add(fork);
		// }
		// for (int i = 0; i < 5; i++) {
		// FiveThinker ft = null;
		// ft = new FiveThinker(i, forks.get(i), forks.get((i + 1) % 5));
		// excutor.submit(ft);
		// }
		// for (int i = 0; i < 5; i++) {
		// FiveThinker ft = null;
		// if (i == 4)
		// ft = new FiveThinker(i, forks.get((i + 1) % 5), forks.get(i));
		// else
		// ft = new FiveThinker(i, forks.get(i), forks.get((i + 1) % 5));
		// excutor.submit(ft);
		// }
		// final String a = "212121";
		// excutor.submit(new Runnable() {
		//
		// @Override
		// public void run() {
		// synchronized (a) {
		// int count=10;
		// while(count>0){
		// System.out.println("A");
		// a.notify();
		// try {
		// Thread.sleep(3000);
		// a.wait();
		// } catch (InterruptedException e) {
		// }
		// }
		// }
		// }
		//
		// });
		// excutor.submit(new Runnable() {
		//
		// @Override
		// public void run() {
		// synchronized (a) {
		// int count=10;
		// while(count>0){
		// System.out.println("B");
		// a.notify();
		// try {
		// Thread.sleep(10000);
		// a.wait();
		// } catch (InterruptedException e) {
		// }
		// }
		// }
		//
		// }
		//
		// });
		Thread t1 = new Thread(new TThread());
		Thread t2 = new Thread(new TThread());
		t1.start();
		t2.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		t2.interrupt();

	}

	static class TThread implements Runnable {
		private static Lock lock = new ReentrantLock();

		@Override
		public void run() {
			try {
				// lock.lock();
				lock.lockInterruptibly();
				System.out
						.println(Thread.currentThread().getName() + "running");
				Thread.sleep(5000);
				System.out.println(Thread.currentThread().getName()
						+ "finished");
			} catch (InterruptedException e) {
				System.out.println(Thread.currentThread().getName() + "被打断");
			} finally {
				lock.unlock();
			}
		}
	}
}
