package com.atguigu.gmall.service.imp;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * ArrayBlockingQueue:是一个基于数组结构的有界阻塞队列，此队列按FIFO（先进先出）原则对元素进行排序
 * LinkedBlockingQueue:一个基于链表结构的阻塞队列，此队列按FIFO排序元素，吞吐量通常高于ArrayBlockingQueue.
 * SynchronousQueue:一个不存储元素的阻塞队列，每个插入操作必须等到另一个线程调用移除操作，否则插入操作一直处于阻塞状态，吞吐量要高
 * 
 * 
 * @author ASUS
 *	1 队列
 *	
 *	2 阻塞队列
 *		2.1 阻塞队列有没有好的一面
 *		
 *			
 *		2.2 不得不阻塞，你如和管理
 *		
 *		
 */

public class BlockingQueueDemo {
	
	public static void main(String[] args) {
		
		List list = new ArrayList();
		System.out.println(Integer.MAX_VALUE);
		
		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<>(3);
//		
//		blockingQueue.add("a");
//		blockingQueue.add("b");
//		blockingQueue.add("c");
		
		blockingQueue.remove();
		blockingQueue.offer("a");
		blockingQueue.offer("a");
		blockingQueue.offer("a");
		blockingQueue.offer("x");
		
		try {
			blockingQueue.put("a");
			blockingQueue.put("b");
			blockingQueue.put("c");
			blockingQueue.put("x");
			System.out.println("=============");
			blockingQueue.take();
			blockingQueue.take();
			blockingQueue.take();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
}
