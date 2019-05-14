package com.atguigu.gmall.service.imp;

import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * 软引用
 * @author ASUS
 *	
 */
public class SoftReferenceDemo {
	
	public static void softRef_Memory_Enough() {
		
		Object o1 = new Object();
		SoftReference<Object> softReference = new SoftReference<Object>(o1);
		System.out.println(o1);
		System.out.println(softReference.get());
		
		o1 = null;
		System.gc();
		
		System.out.println(o1);
		System.out.println(softReference.get());
	}
	
	public static void softRef_Memory_NotEnough() {
		
		Object o1 = new Object();
		SoftReference<Object> softReference = new SoftReference<Object>(o1);
		System.out.println(o1);
		System.out.println(softReference.get());
		
		o1 = null;
		System.gc();
		
		try {
			byte[] bytes = new byte[1000*1024*1024];
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			System.out.println(o1);
			System.out.println(softReference.get());
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		//softRef_Memory_Enough();
		softRef_Memory_NotEnough();
		
	//	Map<String,SoftReference<Bitmap>> image = new HashMap<String,SoftReference<Bitmap>>();用法思路
		
		
	}
}
