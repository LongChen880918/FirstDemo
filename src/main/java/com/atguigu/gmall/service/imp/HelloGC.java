package com.atguigu.gmall.service.imp;

public class HelloGC {	
	
	public static void main(String[] args) throws InterruptedException {
		
		System.out.println("********HelloGC");
		
		long totalMemory = Runtime.getRuntime().totalMemory();//返回Java虚拟机中的内存总量
		long maxMemory = Runtime.getRuntime().maxMemory();//返回java虚拟机使用的最大内存量
		System.out.println("totalMemory(-Xms)="+totalMemory+"(字节)、"+(totalMemory/(double)1024)/1024+"MB");
		System.out.println("maxMemory(-Xmx)="+maxMemory+"(字节)、"+(maxMemory/(double)1024)/1024+"MB");
		
	}
}
