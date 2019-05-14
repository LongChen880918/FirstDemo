package com.atguigu.gmall.service.imp;

import java.util.Random;

/*
 * 堆内存溢出
 */
public class JavaHeapSpaceDemo {
	
	public static void main(String[] args) {
		String str = "atgui";
		while(true) {
			byte[] data = new byte[80*1024*1024];
			str +=str+new Random().nextInt(10000)+new Random().nextInt(22222);
			str.intern();//ava.lang.OutOfMemoryError: Java heap space
		}
		
		
	}
	
}
