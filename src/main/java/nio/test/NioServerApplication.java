/**
 * @Title: NioApplication.java
 * @Package nio.test
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-6-2 下午3:03:44
 * @version V1.0
 */
package nio.test;

import java.io.IOException;

/**  
 * @ClassName: NioApplication  
 * @Description: TODO  
 *    
 */
public class NioServerApplication {

	/**  
	 * @Title: main  
	 * @Description: TODO(这里用一句话描述这个方法的作用)  
	 * @param args    设定文件  
	 * @return void    返回类型  
	 * @throws  
	 */
	public static void main(String[] args) {
		try {
			ReadAndWrite rw=new ReadAndWrite();
			new Thread(rw).start();
			NioServer server =new NioServer(rw);
			server.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
