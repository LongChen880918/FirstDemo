package com.atguigu.gmall.service.imp;

import java.util.ArrayList;
import java.util.List;

/**
 * oom
 * @author ASUS
 *	java 98%的时间在做gc，并且回收了不到2%的效果，会抛出outofmerroyerror
 */
public class GCoverHeadDemo {
	
	public static void main(String[] args) {
		int i=0;
		List<String> list = new ArrayList<>();
		try {
			while(true) {
				list.add(String.valueOf(++i).intern());
			}
			
			
		} catch (Exception e) {
			System.out.println("***************i："+i);
			// TODO: handle exception
			e.printStackTrace();
			throw e;
		}
		
		
	}
	
	
}
