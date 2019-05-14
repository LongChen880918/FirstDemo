package com.tedu;

import java.util.HashMap;
import java.util.Map;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalException {
	
	@ExceptionHandler
	@ResponseBody
	public Map<String,Object> handleException(Exception exception){
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("errorCode", 500);
		map.put("errmsg", exception.toString());
		return map;
		
	}
	
	
}
