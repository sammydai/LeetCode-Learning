package com.learning.io;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.ArrayList;
import java.util.List;

/**
 * [一句话描述该类的功能]
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/6/6 14:49]
 */
public class NIOServerDemo {
	public static List<SocketChannel> channelList = new ArrayList<>();

	public static void main(String[] args) throws InterruptedException {

		try {
			// 相当于serverSocket
			ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
			// 将监听socket设置为非阻塞
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.socket().bind(new InetSocketAddress(8099));
			while (true) {
				// 这里将不再阻塞
				SocketChannel socketChannel = serverSocketChannel.accept();

				if (socketChannel != null) {
					// 将连接socket设置为非阻塞
					socketChannel.configureBlocking(false);
					channelList.add(socketChannel);
				} else {
					System.out.println("没有客户端连接！！！");
				}

				for (SocketChannel client : channelList) {
					ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
					// read也不阻塞
					int num = client.read(byteBuffer);
					if (num > 0) {
						System.out.println("收到客户端【" + client.socket().getPort() + "】数据：" + new String(byteBuffer.array()));
					} else {
						System.out.println("等待客户端【" + client.socket().getPort() + "】写数据");
					}
				}

				// 加个睡眠是为了避免strace产生大量日志，否则不好追踪
				Thread.sleep(1000);

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
