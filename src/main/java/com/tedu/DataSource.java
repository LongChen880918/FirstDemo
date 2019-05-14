package com.tedu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;

public class DataSource {
	public static void main(String[] args) {
	Integer i = Integer.valueOf(1);
	int j = i.intValue();
		
		
		
		
		
		
		
	}
	public  Connection GetConnection() {
		Connection cc=null;
		String driver = "org.apache.phoenix.jdbc.PhoenixDriver";
		String url = "jdbc:phoenix:192.168.206.21:2181";
		try {
			Class.forName(driver);
		}catch(Exception e) {
			e.printStackTrace();
		}
		if(cc == null) {
			try {
				cc=DriverManager.getConnection(url);
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return cc;
	}
	
	
	
}
