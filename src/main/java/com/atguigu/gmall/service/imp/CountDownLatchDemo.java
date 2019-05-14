package com.atguigu.gmall.service.imp;

import java.util.concurrent.CountDownLatch;

/**
 * 
 * @author ASUS
 *
 *
 */
public class CountDownLatchDemo {
	
	public static void main(String[] args) throws InterruptedException {
		
		closeDoor();
	}
	
	public static void closeDoor() throws InterruptedException {
		CountDownLatch countDownLatch = new CountDownLatch(6);
		
		
		for(int i=1;i<=6;i++) {
			new Thread(()->{
				System.out.println(Thread.currentThread().getName()+"国被灭");
				countDownLatch.countDown();
			},CountryEnum.forEach_CountryEnum(i).getReMessage()).start();
			
		}
		countDownLatch.await();
		System.out.println();
		System.out.println(CountryEnum.ONE.getRetCode());
		System.out.println(CountryEnum.ONE.getReMessage());
		
		System.out.println("秦国一统天下");
		
	}
	
	
	
}
