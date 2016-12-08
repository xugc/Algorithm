/**
 * @Title ChildException.java
 * @Package parent.child
 * @Description TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-11-4 上午11:02:32
 * @version V1.0
 */
package parent.child;

/**
 * @ClassName ChildException
 * @Description TODO
 * 
 */
public class ChildException extends Exception {
	private String e;

	static{
		System.out.println("static inti");
	}
	public ChildException(String m) {
		System.out.println("inti");
		this.e = m;
	}

	public String getE() {
		return e;
	}

	public void setE(String e) {
		this.e = e;
	}

}
