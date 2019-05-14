package com.atguigu.gmall.service.imp;

/**
 * OOM出错
 * @author ASUS
 *栈内存溢出
 */
public class StackOverFlowErrorDemo {
	
	public static void main(String[] args) {
		
		StackOverFlowError();//栈空间撑爆
		
		
	}

	private static void StackOverFlowError() {
		StackOverFlowError();//.StackOverFlowErrorDemo.StackOverFlowError
	}
}
