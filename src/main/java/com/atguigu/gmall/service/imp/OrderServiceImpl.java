package com.atguigu.gmall.service.imp;

import com.atguigu.gmall.service.OrderService;

public class OrderServiceImpl implements OrderService {

	@Override
	public void initOrder(String userId) {
		
		//需要查询用户的收获地址
		
	}
	public static void main(String[] args) {
		
		int num =3;
		for(int i=-3;i<=num;i++) {
			for(int j=-3;j<=num;j++) {
				if((Math.abs(i)+Math.abs(j))<num) {
					System.out.println("*");
				}else {
					System.out.print(" ");
				}
			}
		}
	}
	
	
	
	
	

}
