package com.atguigu.gmall.service.imp;

import java.sql.Time;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.atomic.AtomicStampedReference;

class User{
	String userName;
	int age;
	public User(String userName,int age) {
		this.userName=userName;
		this.age = age;
	}
	
}


public class ABADemo {  
	static AtomicReference<Integer> aa = new AtomicReference<Integer>(100);
	static AtomicStampedReference<Integer> bb = new AtomicStampedReference<Integer>(100, 1);
	
	//ABA问题的解决 AtomicStampedReference
	public static void main(String[] args) {
		User z3 = new User("z3",22);
		User li4 = new User("lisi", 25);
		AtomicReference<User> atomicReference = new AtomicReference<>();
		atomicReference.set(z3);
		
		System.out.println(atomicReference.compareAndSet(z3, li4)+"\t"+atomicReference.get().toString());
		System.out.println(atomicReference.compareAndSet(z3, li4)+"\t"+atomicReference.get().toString());
		
		//以下是ABA问题的产生
		new Thread(()->{
			aa.compareAndSet(100, 101);
			aa.compareAndSet(101, 100);
		},"t1").start();
		new Thread(()->{
			try {
				TimeUnit.SECONDS.sleep(1);
				
				System.out.println(aa.compareAndSet(100, 2019)+"\t"+aa.get());
			}catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		},"t2").start(); 
		
		System.out.println("*******以下是ABA问题的解决");
		
		new Thread(()->{
			int stamp=bb.getStamp();
			System.out.println(Thread.currentThread().getName()+"\t第一次版本号:"+bb.getStamp());
			//暂停1秒钟t3线程，保证上面的t3线程完成了一次ABA操作
			try {
				TimeUnit.SECONDS.sleep(1);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			bb.compareAndSet(100, 101, bb.getStamp(), bb.getStamp()+1);
			System.out.println(Thread.currentThread().getName()+"\t第二次版本号"+bb.getStamp());
			bb.compareAndSet(101, 100, bb.getStamp(), bb.getStamp()+1);
			System.out.println(Thread.currentThread().getName()+"\t第三次版本号"+bb.getStamp());
		},"t3").start();
		
		new Thread(()->{
			int stamp =bb.getStamp();
			System.out.println(Thread.currentThread().getName()+"\t第一次版本号："+stamp);
			try {
				TimeUnit.SECONDS.sleep(3);
			} catch (Exception e2) {
				// TODO: handle exception
			}
			boolean result=bb.compareAndSet(100, 2019, stamp, stamp+1);
			System.out.println(Thread.currentThread().getName()+"\t t4线程成功否："+result+"\t当前实际版本号："+bb.getStamp());
			System.out.println("当前实际值："+bb.getReference());
			
			
		},"t4").start();
		
		
		
		
		
	}
	
}
