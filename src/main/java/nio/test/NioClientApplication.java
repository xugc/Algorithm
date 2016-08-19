/**
 * @Title: NioClientApplication.java
 * @Package nio.test
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-6-2 下午3:05:22
 * @version V1.0
 */
package nio.test;

import java.io.IOException;

/**
 * @ClassName: NioClientApplication
 * @Description: TODO
 * 
 */
public class NioClientApplication {

	/**
	 * @Title: main
	 * @Description: TODO(这里用一句话描述这个方法的作用)
	 * @param args
	 *            设定文件
	 * @return void 返回类型
	 * @throws
	 */
	public static void main(String[] args) {
		try {
			ReadAndWrite rw = new ReadAndWrite();
			new Thread(rw).start();
			ClientConnector cc = new ClientConnector();
			cc.start();
			NioClient client = new NioClient("first", rw);
			client.setHost("localhost");
			client.setPort(9600);
			cc.postConnect(client);
			NioClient client2 = new NioClient("second", rw);
			client2.setHost("localhost");
			client2.setPort(9600);
			cc.postConnect(client2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
