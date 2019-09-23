package com.atguigu.gmall.service.imp;

import java.util.HashMap;
import java.util.Map;

public class MapDemo {
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		Map a = new HashMap<>();
		a.put("a", 11);
		a.put("b", 22);
		Map b = new HashMap<>();
		b.put("c", 33);
		b.put("d", 44);
		
		Map paramMap = new HashMap<>();
		paramMap.putAll(a);
		paramMap.putAll(b);
		System.out.println(paramMap);
		String abc = "abc";
		String abcdefg="ab cdefg";
		System.out.println(abcdefg.contains(abc));
		
	}
}
