package com.atguigu.gmall.service.imp;

import java.lang.ref.WeakReference;

public class WeakReferenceDemo {
	public static void main(String[] args) {
		Object o1 = new Object();
		WeakReference<Object> weak = new WeakReference<Object>(o1);
		System.out.println(o1);
		System.out.println(weak.get());
		o1 =null;
		System.gc();
		System.out.println(o1);
		System.out.println(weak.get());
		
	}
}
