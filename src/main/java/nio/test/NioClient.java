/**
 * @Title: NioClient.java
 * @Package nio.test
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-6-2 上午9:56:31
 * @version V1.0
 */
package nio.test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.ClosedChannelException;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;

import nio.test.inter.NioConnection;

/**
 * @ClassName: NioClient
 * @Description: TODO
 * 
 */
public class NioClient implements NioConnection{
	private ReadAndWrite readAndWrite;
	private String id;
	private SocketChannel channel;
	private String host;
	private Integer port;
	private ByteBuffer bb = ByteBuffer.allocate(1024 * 64);
	
	private SendAgent agent;

	public NioClient(String id,ReadAndWrite readAndWrite) throws IOException {
		this.id=id;
		channel = SocketChannel.open();
		channel.configureBlocking(false);
		this.readAndWrite = readAndWrite;
		this.agent=new SendAgent();
	}

	public SocketChannel getChannel() {
		return channel;
	}

	public void setChannel(SocketChannel channel) {
		this.channel = channel;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	private void send() {
		int i = 0;
		for (;;) {
			try {
				Thread.sleep(3000);
				bb.clear();
				bb.put(("["+id+"]abc" + (i++)).getBytes());
				bb.flip();
				channel.write(bb);
				bb.clear();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void register() throws ClosedChannelException{
		readAndWrite.registerRead(this);
		new Thread(agent).start();
	}

	@Override
	public void read() throws IOException {
		CharBuffer charBuffer = null;
		bb.clear();
		channel.read(bb);
		bb.flip();
		Charset charset = Charset.forName("UTF-8");
		CharsetDecoder decoder = charset.newDecoder();
		charBuffer = decoder.decode(bb);
		System.out.println(charBuffer.toString().trim().replace("\r\n", "")
				+ " is received");
		bb.clear();
	}
	
	@Override
	public void write(byte[] data) throws IOException {
	}

	private class SendAgent implements Runnable{

		@Override
		public void run() {
			send();
		}
		
	}
	
}
