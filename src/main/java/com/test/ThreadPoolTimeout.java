/**
 * @Title ThreadPoolTimeout.java
 * @Package com.test
 * @Description TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-11-1 上午10:22:50
 * @version V1.0
 */
package com.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * @ClassName ThreadPoolTimeout
 * @Description TODO
 * 
 */
public class ThreadPoolTimeout {
	private static class Test {
		private String tt;
		
		public static String s=null;

		public String getTt() {
			return tt;
		}

		public void setTt(String tt) {
			this.tt = tt;
		}

		@Override
		public String toString() {
			return "Test [tt=" + tt + "]";
		}

	}

	public static void main(String[] args) {
		Test t=new Test();
		System.out.println(t.s);
		ExecutorService executor = Executors.newSingleThreadExecutor();
		Future<Test> result = executor.submit(new Callable<Test>() {

			@Override
			public Test call() throws Exception {
				System.out.println("t1");
				Thread.currentThread().sleep(5000);
				Test t = new Test();
				t.setTt("abc1");
				return t;
			}

		});
		Future<Test> result2 = executor.submit(new Callable<Test>() {

			@Override
			public Test call() throws Exception {
				System.out.println("t2");
				Test t = new Test();
				t.setTt("abc2");
				return t;
			}

		});
		try {
			System.out.println("get");
			System.out.println(result2.get(2, TimeUnit.SECONDS));
			System.out.println("inner over");
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		try {
			System.out.println(result.get());
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("over");
	}
}
