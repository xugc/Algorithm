/**
 * @Title TestExp.java
 * @Package parent.child
 * @Description TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-11-4 上午11:03:09
 * @version V1.0
 */
package parent.child;

/**
 * @ClassName TestExp
 * @Description TODO
 * 
 */
public class TestExp {
	static{
		i=3;
	}
	static int i=2;
	public TestExp(){
		i=4;
		System.out.println(i);
	}
	

	public void printName(Exception e) {
		System.out.println(e.getClass().getName());
	}

	/**
	 * @Title main
	 * @Description TODO(这里用一句话描述这个方法的作用)
	 * @param args
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void main(String[] args) {
//		ParentTest pt=new ParentTest();
//		System.out.println(pt.e.getE());
//		ChildTest ct=new ChildTest();
//		System.out.println(ParentTest.e.hashCode());
		System.out.println(ChildTest.e==ParentTest.e);
//		ChildException ce = new ChildException();
//		TestExp te = new TestExp();
//		te.printName(ce);
//		
//		new Thread(new Runnable(){
//
//			@Override
//			public void run() {
//				System.out.println("m");
//				new Thread(new Runnable(){
//
//					@Override
//					public void run() {
//						System.out.println("s");
//						try {
//							Thread.currentThread().sleep(5000);
//						} catch (InterruptedException e) {
//							// TODO Auto-generated catch block
//							e.printStackTrace();
//						}
//						System.out.println("s end");
//					}
//					
//				}).start();
//				try {
//					Thread.currentThread().sleep(2000);
//				} catch (InterruptedException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				System.out.println("m end");
//			}
//			
//		}).start();

	}

}
