/**
 * @Title: NioConnection.java
 * @Package nio.test.inter
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-6-3 下午2:37:02
 * @version V1.0
 */
package nio.test.inter;

import java.io.IOException;
import java.nio.channels.SocketChannel;

/**
 * @ClassName: NioConnection
 * @Description: TODO
 * 
 */
public interface NioConnection {
	public void read() throws IOException;
	
	public void write(byte[] data) throws IOException;

	public SocketChannel getChannel();
}
