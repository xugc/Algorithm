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
		ChildException ce = new ChildException();
		TestExp te = new TestExp();
		te.printName(ce);

	}

}
