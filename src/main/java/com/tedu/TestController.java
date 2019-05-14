package com.tedu;

import java.util.concurrent.Future;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.service.AsyncService;

@Controller
public class TestController {
	
	@Autowired
	private AsyncService asy;
	
	
	@ResponseBody
	@RequestMapping("/show")
	public String show() {
		//int a = 5/0;
		int[] a = new int[3];
		System.out.println(a[3]);
		return "show";
	}
	
	@ResponseBody
	@RequestMapping("/async")
	public String asyncTest() throws Exception {
		long start = System.currentTimeMillis();
		Future<String> doTask1 = asy.doTask1();
		Future<String> doTask2 = asy.doTask2();
		Future<String> doTask3 = asy.doTask3();
		
		while(true) {
			if(doTask1.isDone()&&doTask2.isDone()&&doTask3.isDone()) {
				break;
			}
			Thread.sleep(1000);
			
		}
		long end = System.currentTimeMillis();
		
		
		return "全部完成耗时："+(end-start)+"毫秒";
	}
	
	
	
	
	
	
	
}
