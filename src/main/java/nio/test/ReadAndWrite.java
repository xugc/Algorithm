/**
 * @Title: ReadAndWrite.java
 * @Package nio.test
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-6-2 下午2:18:58
 * @version V1.0
 */
package nio.test;

import java.io.IOException;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

import nio.test.inter.NioConnection;

/**
 * @ClassName: ReadAndWrite
 * @Description: TODO
 * 
 */
public class ReadAndWrite implements Runnable {
	private Selector selector;
	private Queue<NioConnection> connections = new ConcurrentLinkedQueue<NioConnection>();

	public ReadAndWrite() throws IOException {
		selector = Selector.open();
	}

	public void registerRead(NioConnection con) throws ClosedChannelException {
		connections.offer(con);
		con.getChannel().register(selector, SelectionKey.OP_READ, con);
	}

	public void registerWrite(NioConnection con) throws ClosedChannelException {
		connections.offer(con);
		con.getChannel().register(selector, SelectionKey.OP_WRITE, con);
	}

	@Override
	public void run() {
		Selector sel = selector;
		for (;;) {
			try {
				sel.select(1000L);
				Set<SelectionKey> keys = sel.selectedKeys();
				try {
					for (SelectionKey key : keys) {
						if (key.isValid() && key.isReadable()) {
							NioConnection con = (NioConnection) key
									.attachment();
							con.read();
						} else if (key.isValid() && key.isWritable()) {
						} else {
							key.cancel();
						}
					}
				} finally {
					keys.clear();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
