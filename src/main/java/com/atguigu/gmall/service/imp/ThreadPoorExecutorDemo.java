package com.atguigu.gmall.service.imp;

import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author ASUS
 *第四种获得/使用java多线程的方式，线程池
 */
public class ThreadPoorExecutorDemo {
	
	public static void main(String[] args) {
		
		System.out.println(Runtime.getRuntime().availableProcessors());
		
		
		ExecutorService threadPool = new  ThreadPoolExecutor(2,5,1L,TimeUnit.SECONDS,
															 new LinkedBlockingQueue<Runnable>(3),
															 Executors.defaultThreadFactory(),
															 new ThreadPoolExecutor.DiscardPolicy());
		
		try {
			for(int i=1;i<=10;i++) {
				threadPool.execute(()->{
					System.out.println(Thread.currentThread().getName()+"\t 办理业务");
				});
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			threadPool.shutdown();
		}
		
		
		
		
	}
	public static void testThread() {
		Executors.newScheduledThreadPool(20);
		ExecutorService threadPool1 = Executors.newFixedThreadPool(5);//一池5个线程，执行长期任务
		ExecutorService threadPool2 = Executors.newSingleThreadExecutor();//单线程池一个任务一个任务的执行
		ExecutorService threadPool3 = Executors.newCachedThreadPool();//缓存线程池的，执行很多很短的小程序或者负载较轻的服务
		
			
		
	
		
		
	}
	
}
