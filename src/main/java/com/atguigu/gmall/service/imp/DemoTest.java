package com.atguigu.gmall.service.imp;

import java.util.Arrays;
import java.util.Random;

public class DemoTest {
	public static void main(String[] args) {
		
		 int[] hole = new int[] {1,2,3};
		 double right=0;
		 double wrong=0;
		 
		 int a;
		 for(int i=1;i<=100000;i++) {
			 int baozang = new Random().nextInt(3)+1;
			 int woxuan = new Random().nextInt(3)+1;
			 int dakai = woxuan+1>3?1:woxuan+1;
			 if(dakai==baozang) {
				 wrong++;
				 continue;
			 }
			 if(woxuan==baozang) {
				 right++;
			 }
		 }
		 double sycs= 100000-wrong;
		 double gl = right/sycs;
		 System.out.println("实验次数:"+sycs);
		 System.out.println("坚持我选的概率:"+gl);
		 
		 
		
	}
}
