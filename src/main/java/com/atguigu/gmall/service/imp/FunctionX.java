package com.atguigu.gmall.service.imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
public class FunctionX {
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



		List<Map<String,Object>> result =new ArrayList<>();

		Map<String, List<Map<String, Object>>> glist = list.stream().collect(Collectors.groupingBy(e -> e.get("SFZH").toString()));
		
		list.stream().collect(Collectors.groupingBy(e->e.get("SFZH").toString()));
		  
		System.out.println(glist);
		glist.forEach((k,slist)->{
		Map<String,Object> nmap=new HashMap<>();
		IntSummaryStatistics sumcc = slist.stream().collect(Collectors.summarizingInt(e->Integer.valueOf("1")));
		
		IntSummaryStatistics intSummaryStatistics = slist.stream().collect(Collectors.summarizingInt(e->Integer.valueOf("1")));
		System.out.println(sumcc.toString());
		
		if(sumcc.getSum()>1) {
			slist.forEach(x->{
				result.add(x);
			});
			
		}
		System.out.println("sumcc:"+sumcc.toString());
		System.out.println("k："+k);
		System.out.println("slist:"+slist); 
		
		}); 
		
		System.out.println(glist.toString());
		
		System.out.println("--------testMerge-------------");
		result.forEach(x->{
			System.out.println(x);
		});
	}
}
