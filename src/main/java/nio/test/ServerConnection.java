/**
 * @Title: ServerConnection.java
 * @Package nio.test
 * @Description: TODO
 * Copyright: Copyright (c) 2016 
 * Company:*******
 * 
 * @author 徐故成
 * @date 2016-6-3 下午2:59:16
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
 * @ClassName: ServerConnection
 * @Description: TODO
 * 
 */
public class ServerConnection implements NioConnection {

	private SocketChannel channel;
	private ByteBuffer bb = ByteBuffer.allocate(1024 * 1024 * 64);

	public ServerConnection(SocketChannel channel) {
		this.channel = channel;
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
		answer("hello " + charBuffer.toString());
	}

	@Override
	public void write(byte[] data) throws IOException {
		
	}

	@Override
	public SocketChannel getChannel() {
		return channel;
	}

	public void answer(String answerStr) throws IOException {
		bb.clear();
		bb.put(answerStr.getBytes());
		bb.flip();
		channel.write(bb);
		bb.clear();
	}
	
	public void register(ReadAndWrite readAndWrite) throws ClosedChannelException{
		readAndWrite.registerRead(this);
	}

}
