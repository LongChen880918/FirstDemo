package com.atguigu.gmall.service.imp;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * volatile/CAS/atomicInteger/BlockQueue/线程交互/原子引用
 * @author ASUS
 *
 */
public class ProdConsumer_BlcokQueueDemo {
	
	public static void main(String[] args) {
		
		ShareDate date = new ShareDate(new ArrayBlockingQueue<>(3));
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"\t生产启动");
			try {
				date.myProd();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		
		},"Prod").start();
		new Thread(()->{
			System.out.println(Thread.currentThread().getName()+"\t消费启动");
			try {
				date.myConsumer();
				System.out.println();
				System.out.println();
			} catch (Exception e) {
				// TODO: handle exception
			}
			
		
		},"Consumer").start();
		
		System.out.println("----------");
		System.out.println("5秒钟时间到，老板叫停");
		
		try {
			TimeUnit.SECONDS.sleep(5);
			date.stop();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}


class ShareDate{
	
	private volatile boolean Flag = true;//默认开启，进行生产加消费
	private AtomicInteger atomic = new AtomicInteger();
	BlockingQueue<String> blockingQueue = null;
	
	public ShareDate(BlockingQueue<String> blockingQueue) {
		this.blockingQueue = blockingQueue;
		System.out.println(blockingQueue.getClass().getName());
		
	}
	
	public void myProd() throws Exception {
		String data =null;
		boolean reTvalue;
		while(Flag) {
			data =atomic.incrementAndGet()+"";
			reTvalue=blockingQueue.offer(data,2L,TimeUnit.SECONDS);
			if(reTvalue) {
				System.out.println(Thread.currentThread().getName()+"\t插入队列"+data+"成功");
			}else {
				System.out.println(Thread.currentThread().getName()+"\t插入队列"+data+"失败");
			}
			TimeUnit.SECONDS.sleep(1);
			
			
			
		}
		System.out.println(Thread.currentThread().getName()+"\t大老板叫停来，表示");
		
		
		
	}
	public void myConsumer() throws Exception{
		
		String result=null;
		while(Flag) {
			result = blockingQueue.poll(2L, TimeUnit.SECONDS);
			if(null==result||result.equalsIgnoreCase("")) {
				Flag=false;
				System.out.println(Thread.currentThread().getName()+"\t超过2秒没有取到蛋糕，消费退出");
				System.out.println();
				System.out.println();
				
				return;
			}
			System.out.println(Thread.currentThread().getName()+"\t消费队列"+result+"成功");
		}
	}
	
	public void stop() throws Exception{
		this.Flag=false;
	}
	
	
	
}