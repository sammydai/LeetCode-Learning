package com.learning.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * [一句话描述该类的功能]
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/6/6 14:39]
 */
public class BIOServerDemo {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;

		try {
			serverSocket = new ServerSocket(8099);
			System.out.println("启动服务：监听端口:8099");
			// 等待客户端的连接过来,如果没有连接过来，就会阻塞
			while (true) {
				// 表示阻塞等待监听一个客户端连接,返回的socket表示连接的客户端信息
				Socket socket = serverSocket.accept(); //连接阻塞
				System.out.println("客户端：" + socket.getPort());
				// 表示获取客户端的请求报文
				new Thread(new Runnable() {
					@Override
					public void run() {
						try {
							BufferedReader bufferedReader = new BufferedReader(
									new InputStreamReader(socket.getInputStream())
							);
							String clientStr = bufferedReader.readLine();
							System.out.println("收到客户端发送的消息：" + clientStr);

							BufferedWriter bufferedWriter = new BufferedWriter(
									new OutputStreamWriter(socket.getOutputStream())
							);
							bufferedWriter.write("ok\n");
							bufferedWriter.flush();
						} catch (Exception e) {
							//...
						}

					}
				}).start();
			}
		} catch (IOException e) {
			// 错误处理
		}
	}

}
