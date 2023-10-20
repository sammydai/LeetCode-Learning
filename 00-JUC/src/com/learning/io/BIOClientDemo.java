package com.learning.io;

import java.io.*;
import java.net.Socket;

/**
 * BIOClientDemo
 *
 * @author : [Sammy]
 * @version : [v1.0]
 * @createTime : [2023/6/6 14:40]
 */
public class BIOClientDemo {
	public static void main(String[] args) {

		try {
			// 创建套接字 & 建立连接
			Socket socket = new Socket("localhost", 8099);
			// 向服务端写数据
			BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			bufferedWriter.write("我是客户端，收到请回答！！\n");
			bufferedWriter.flush();

			BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String line = bufferedReader.readLine();
			System.out.println("收到服务端返回的数据：" + line);
		} catch (IOException e) {
			// 错误处理
		}
	}
}
