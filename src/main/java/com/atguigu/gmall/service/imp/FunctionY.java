package com.atguigu.gmall.service.imp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FunctionY {
	public static void main(String[] args) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("name", "a");
		map.put("price",500);
		map.put("SFZH",360426);

		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("name", "a");
		map2.put("price",1500);
		map2.put("SFZH",360426);

		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("name", "b");
		map3.put("price",300);
		map3.put("SFZH",360000);

		List<Map<String, Object>> list = new ArrayList<Map<String,Object>>();
		list.add(map);
		list.add(map2);
		list.add(map3);
		List ids = new ArrayList();
		List count = new ArrayList();
		List<Map<String, Object>> personList = list.stream().filter(// 过滤去重
           v -> { 
        	   String name = v.get("name").toString()+v.get("price").toString();
        	   int num =1;
               boolean flag = !ids.contains(name);
               if(!flag) {	
            	   count.add(num);
               }
               ids.add(name);
               return flag;
           }
	       ).collect(Collectors.toList()); 
       System.out.println(personList);
       System.out.println(ids);
       System.out.println(count);
	}

}
