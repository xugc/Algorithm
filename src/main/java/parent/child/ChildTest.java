/**
 * @Title ChildTest.java
 * @Package parent.child
 * @Description TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-12-7 下午2:26:00
 * @version V1.0
 */
package parent.child;

/**  
 * @ClassName ChildTest  
 * @Description TODO  
 *    
 */
public class ChildTest extends ParentTest {
	static{
		System.out.println("ct init bug2");
	}
}
