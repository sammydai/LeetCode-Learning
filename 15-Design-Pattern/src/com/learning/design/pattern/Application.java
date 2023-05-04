package com.learning.design.pattern;

/**
 * @Package: com.learning.design.pattern
 * @Description: Application Test
 * @Author: Sammy
 * @Date: 2022/6/30 11:06
 */

public class Application {
	public static void main(String[] args) {
		HandlerChain chain = new HandlerChain();
		chain.addHandler(new HandlerA());
		chain.addHandler(new HandlerB());
		chain.handle();
	}
}
