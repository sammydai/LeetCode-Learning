package com.learning.design.pattern;

/**
 * @Package: com.learning.design.pattern
 * @Description: Hanlder Test
 * @Author: Sammy
 * @Date: 2022/6/30 11:01
 */

public abstract class Handler {

	protected Handler successor = null;

	public void setSuccessor(Handler successor) {
		this.successor = successor;
	}

	public final void handle() {
		boolean handled = doHandle();
		if (successor != null && !handled) {
			successor.handle();
		}
	}

	protected abstract boolean doHandle();
}

