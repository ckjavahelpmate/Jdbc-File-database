package com.ty.files.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionObject {
	
	public static Connection getConnection() {
		try {
			return DriverManager.getConnection(UC.URL, UC.USERNAME, UC.PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}