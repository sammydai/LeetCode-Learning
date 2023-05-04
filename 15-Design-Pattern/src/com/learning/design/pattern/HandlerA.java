package com.learning.design.pattern;

/**
 * @Package: com.learning.design.pattern
 * @Description: HandlerA
 * @Author: Sammy
 * @Date: 2022/6/30 11:05
 */

public class HandlerA extends Handler {

	@Override
	protected boolean doHandle() {
		boolean handled = false;
		//Handler A自己的处理
		return handled;
	}
}
