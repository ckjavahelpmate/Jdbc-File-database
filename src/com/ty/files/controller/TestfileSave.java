package com.ty.files.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ty.files.util.ConnectionObject;

public class TestfileSave {

	public static void main(String[] args) {

		Connection connection = ConnectionObject.getConnection() ;

		String sql = "insert into documents values(?,?,?,?)" ;

		File f = new File( "C:\\Users\\ck\\Pictures\\Saved Pictures\\ck.webp") ;
		try {
			FileInputStream fin = new FileInputStream(f) ;

			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setInt(1, 5) ;
			preparedStatement.setString(2, "cckk");
			preparedStatement.setString(3, "ck.webp");
			preparedStatement.setBlob(4,fin );
			
			if(preparedStatement.executeUpdate() != 0) System.out.println("Data inserted"); 
			else System.out.println("No data inserted");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}




	}

}
