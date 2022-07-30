package com.learning.design.pattern;

/**
 * @Package: com.learning.design.pattern
 * @Description: HandlerB
 * @Author: Sammy
 * @Date: 2022/6/30 11:07
 */

public class HandlerB extends Handler {

	@Override
	protected boolean doHandle() {
		boolean handled = false;
		//... handler B自己的处理
		return handled;
	}
}
