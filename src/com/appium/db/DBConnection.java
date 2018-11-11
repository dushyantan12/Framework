package com.appium.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Driver;

public class DBConnection {

	private static String DBURL = "";
	private static String UN = "";
	private static String PASS = "";
	
	private static Connection conn = null;
	static Connection getDBConenction() throws SQLException, InstantiationException, IllegalAccessException, ClassNotFoundException {
		
		String className = "com.mysql.jdbc.Driver";
		Class.forName(className).newInstance();
		conn =  DriverManager.getConnection(DBURL,UN,PASS);
		return conn;
	}
}
