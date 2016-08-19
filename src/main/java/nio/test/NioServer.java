/**
 * @Title: NioServer.java
 * @Package nio.test
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-6-2 上午9:55:26
 * @version V1.0
 */
package nio.test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.StandardSocketOptions;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * @ClassName: NioServer
 * @Description: TODO
 * 
 */
public class NioServer extends Thread {
	private Selector selector;
	private ServerSocketChannel channel;
	private ReadAndWrite readAndWrite;

	public NioServer(ReadAndWrite readAndWrite) throws IOException {
		this.readAndWrite = readAndWrite;
		this.selector = Selector.open();
		this.channel = ServerSocketChannel.open();
		this.channel.configureBlocking(false);
		this.channel.setOption(StandardSocketOptions.SO_REUSEADDR, true);
		this.channel.setOption(StandardSocketOptions.SO_RCVBUF, 1024 * 64);
		channel.bind(new InetSocketAddress(9600), 100);
		this.channel.register(selector, SelectionKey.OP_ACCEPT);
	}

	@Override
	public void run() {
		final Selector sel = this.selector;
		for (;;) {
			try {
				sel.select(1000L);
				Set<SelectionKey> keys = sel.selectedKeys();
				try {
					for (SelectionKey key : keys) {
						if (key.isValid() && key.isAcceptable()) {
							SocketChannel socketChannel = channel.accept();
							socketChannel.configureBlocking(false);
							ServerConnection serverConnection=new ServerConnection(socketChannel);
							serverConnection.register(readAndWrite);
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
