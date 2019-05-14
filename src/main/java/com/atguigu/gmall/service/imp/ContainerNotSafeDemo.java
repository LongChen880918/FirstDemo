package com.atguigu.gmall.service.imp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;

/*
 * 集合类不安全的问题
 * ArrayList
 */
public class ContainerNotSafeDemo {
	
	public static void main(String[] args) {
		
		Map<String,String> map =new ConcurrentHashMap<>();// new HashMap();
		for(int i=1;i<=30;i++) {
			new Thread(()-> {
				map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
				System.out.println(map);
			},String.valueOf(i)).start();
		}
		
		
	}
	
	public static void setNotSafe() {
		Set<String> set =new CopyOnWriteArraySet<>();//Collections.synchronizedSet(new HashSet<>());
		for(int i=1;i<=30;i++) {
			new Thread(()-> {
				set.add(UUID.randomUUID().toString().substring(0, 8));
				System.out.println(set);
			},String.valueOf(i)).start();
		}
		new HashSet<>().add("a");//hashset底层是hashMap,只添加一个一个key，value是恒定的Object默认值
	}
	
	
	
	public static void listNotSafe() {
		List<String> list = new Vector();//new ArrayList();
		List<String> aa =Collections.synchronizedList(new ArrayList<>());
		List<String> bb = new CopyOnWriteArrayList<>();
		for(int i=1;i<=30;i++) {
			new Thread(()-> {
				bb.add(UUID.randomUUID().toString().substring(0, 8));
				System.out.println(bb);
			},String.valueOf(i)).start();
		}
		//java.util.ConcurrentModificationException
		/*
		 * 	不要只是会用，会用只不过是API调用工程师
		 * 1:故障现象
		 * 		java.util.ConcurrentModificationException
		 * 		
		 * 2：导致原因
		 * 		并发争抢修改导致，参考我们的花名册签名情况
		 * 		一个人正在写入，另外一个同学过来抢夺，导致数据不一致异常
		 * 		并发修改异常
		 * 
		 * 3：解决方案
		 * 	  3.1 new Vector()
		 * 	  3.2 Collections.synchronizedList(new ArrayList<>());
		 * 	  3.3 new CopyOnWriteArrayList<>;
		 *    
		 * 
		 * 4：优化建议（同样的错误不范第二次）：
		 * 
		 * 
		 */
		
	}
}
