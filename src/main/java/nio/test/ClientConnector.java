/**
 * @Title: ClientConnector.java
 * @Package nio.test
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-6-3 下午2:13:52
 * @version V1.0
 */
package nio.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * @ClassName: ClientConnector
 * @Description: TODO
 * 
 */
public class ClientConnector extends Thread {
	private Queue<NioClient> clientQueue = new ConcurrentLinkedQueue<NioClient>();
	private Selector selector;

	public ClientConnector() throws IOException {
		this.selector = Selector.open();
	}
	
	public void postConnect(NioClient c){
		clientQueue.add(c);
		this.selector.wakeup();
	}

	private void connect(Selector selector) throws IOException {
		NioClient c = null;
		while ((c = clientQueue.poll()) != null) {
			c.getChannel().register(selector, SelectionKey.OP_CONNECT, c);
			c.getChannel().connect(new InetSocketAddress(c.getHost(), c.getPort()));
		}
	}

	@Override
	public void run() {
		final Selector sel = this.selector;
		for (;;) {
			try {
				sel.select(1000L);
				connect(sel);
				Set<SelectionKey> keys = sel.selectedKeys();
				try {
					for (SelectionKey key : keys) {
						if (key.isConnectable()) {
							NioClient client = (NioClient) key.attachment();
							SocketChannel socketChannel = client.getChannel();
							if (socketChannel.isConnectionPending()) {
								if (socketChannel.finishConnect()) {
									client.register();
								}
							}
						} else {
							key.cancel();
						}
					}
				} finally {
					keys.clear();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}

		}
	}

}
