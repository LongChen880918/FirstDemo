package com.atguigu.gmall.service.imp;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class ShareData{//资源类
	private int num =0;
	private Lock lock = new ReentrantLock();
	private Condition condition = lock.newCondition();
	
	
	public void increment() throws Exception{
		lock.lock();
		try {
			//1判断
			while(num != 0) {
				//等待，不能生产
				condition.await();
			}
			//2干活
			num++;
			System.out.println(Thread.currentThread().getName()+"\t"+num);
			
			//3通知，唤醒
			condition.signalAll();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
	}
	
	public void decrement() throws Exception{
		lock.lock();
		try {
			//1判断
			while(num == 0) {
				//等待，不能生产
				condition.await();
			}
			//2干活
			num--;
			System.out.println(Thread.currentThread().getName()+"\t"+num);
			
			//3通知，唤醒
			condition.signalAll();
		} catch (Exception e) {
			// TODO: handle exception
		}finally {
			lock.unlock();
		}
	}
	
}

/**
 * 题目：一个初始值为零的变量，两个线程对其交互操作
 * 一个加一，一个减一，来五轮
 * @author ASUS
 *	1 线程  操作（方法）  资源类
 *	2 判断  干活  通知
 *	3 防止虚假唤醒机制
 *
 */
public class ProdConsumer_TraditionDemo {
	
	public static void main(String[] args) {
		ShareData shareData = new ShareData();
		new Thread(()->{
			for(int i=1;i<=5;i++) {
				try {
					shareData.decrement();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		},"AAA").start();
		new Thread(()->{
			for(int i=1;i<=5;i++) {
				try {
					shareData.increment();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		},"BBB").start();
		new Thread(()->{
			for(int i=1;i<=5;i++) {
				try {
					shareData.decrement();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		},"CCC").start();
		new Thread(()->{
			for(int i=1;i<=5;i++) {
				try {
					shareData.increment();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		},"DDD").start();
		
		
	}
}
