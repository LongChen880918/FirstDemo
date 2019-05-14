package com.atguigu.gmall.service.imp;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 题目：多线程之间顺序调用，实现A->B->C三个线程启动，要求如下
 * AA打印5次，BB打印10次，CC打印15次
 * 来10轮
 * @author ASUS
 *
 */
class ShareResource{
	private int num = 1;//A:1,B:2,C:3
	private Lock lock = new ReentrantLock();
	private Condition c1 = lock.newCondition();
	private Condition c2 = lock.newCondition();
	private Condition c3 = lock.newCondition();
	Map map = new ConcurrentHashMap<>();	
	//1判断
	public void prints5() {
		lock.lock();
		try {
			while(num!=1) {
				c1.await();
			}
			//2干活
			for(int i=1;i<=5;i++) {
				System.out.println(Thread.currentThread().getName()+"\t"+i);
			}
			
			//3唤醒 通知
			num=2;
			c2.signal();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
	}
	public void prints10() {
			lock.lock();
			try {
				while(num!=2) {
					c2.await();
				}
				//2干活
				for(int i=1;i<=10;i++) {
					System.out.println(Thread.currentThread().getName()+"\t"+i);
				}
				
				//3唤醒 通知
				num=3;
				c3.signal();
			} catch (Exception e) {
				// TODO: handle exception
			}finally {
				lock.unlock();
			}
		
	}
	
	public void prints15() {
		lock.lock();
		try {
			while(num!=3) {
				c3.await();
			}
			//2干活
			for(int i=1;i<=15;i++) {
				System.out.println(Thread.currentThread().getName()+"\t"+i);
			}
			
			//3唤醒 通知
			num=1;
			c1.signal();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			lock.unlock();
		}
	
}
	
	
}
public class SyncAndReentrantLock {
	
	public static void main(String[] args) {
		
		ShareResource aa = new ShareResource();
		new Thread(()->{
			for(int i=1;i<=10;i++) {
				aa.prints5();
			}
			
		},"A").start();
		new Thread(()->{
			for(int i=1;i<=10;i++) {
				aa.prints10();
			}
			
		},"B").start();
		new Thread(()->{
			for(int i=1;i<=10;i++) {
				aa.prints15();
			}
			
		},"C").start();
		
	}
	
	
}
