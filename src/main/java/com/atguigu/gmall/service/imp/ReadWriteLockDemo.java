package com.atguigu.gmall.service.imp;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/*
 * 多个线程同时读一个资源类没有任何问题，所以为了满足并发量
 * 读取共享资源应该可以同时进行
 * 但是
 * 如果有一个线程想去写共享资源来，就不应该再有其他线程可以对
 * 该资源进行读或写
 * 总结：读读能共存
 * 		 读写不能共存
 * 		 写写不能共存
 */
public class ReadWriteLockDemo {
	
	public static void main(String[] args) {
		MyCache myCache = new MyCache();
		for(int i=1;i<=5;i++) {
			final int tempInt =i;
			new Thread(()->{
				myCache.put(tempInt+"",tempInt+"");
			},String.valueOf(i)).start();
		}
		
		for(int i=1;i<=5;i++) {
			final int tempInt =i;
			new Thread(()->{
				myCache.get(tempInt+"");
			},String.valueOf(i)).start();
		}
		
		
	}
	
}

class MyCache{//资源类
	private volatile Map<String,Object> map = new HashMap<>();
	private Lock lock = new ReentrantLock();
	private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();
	
	
	public void put(String key,Object value) {
		rwlock.writeLock().lock();
		
		System.out.println(Thread.currentThread().getName()+"\t 正在写入："+key);
		try {
			TimeUnit.MICROSECONDS.sleep(300);
			map.put(key, value);
			System.out.println("写入完成");
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			rwlock.writeLock().unlock();
		}
		
		
	
	
	}
	
	public void get(String key) {
		rwlock.readLock().lock();
		System.out.println("正在读取。。");
		try {
			TimeUnit.MICROSECONDS.sleep(300);
			Object result = map.get(key);
			System.out.println("读取完成："+result);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			rwlock.readLock().unlock();
		}
		
	}
	
	
}
