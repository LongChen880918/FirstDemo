package com.tedu;

import java.nio.charset.Charset;

import org.apache.catalina.User;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
@EnableAutoConfiguration
@RequestMapping("/dd")
@RestController
public class ControllerFirst {
	
	//自定义消息转换器
	@Bean
	public StringHttpMessageConverter stringHttpMessageConverter() {
		StringHttpMessageConverter cpnvert = new StringHttpMessageConverter(Charset.forName("utf-8"));
		return cpnvert;
	}
	
	
	
	
	@RequestMapping("/ff")
	public String first() {
		System.out.println("111");
		return "hello world";
	}
	
	@RequestMapping("/ok")
	public String ok() {
		return "Ok"+"";
	}
	
	@RequestMapping("/info/{msg}")
	public String show(@PathVariable String msg) {
		
		return "show"+msg;
	}
	@RequestMapping("/info/{user}")
	public String save(@PathVariable User user ) {
		
		return null;
	}
	
	
	
	
	
	
}
