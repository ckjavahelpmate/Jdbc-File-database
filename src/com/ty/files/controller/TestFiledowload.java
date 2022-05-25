package com.ty.files.controller;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ty.files.util.ConnectionObject;

public class TestFiledowload {

	public static void main(String[] args) {
		
		Connection connection = ConnectionObject.getConnection() ;
		
		String sql = "select * from documents where id=?" ;
		
		try {
			PreparedStatement preparedStatement = connection.prepareStatement(sql) ;
			preparedStatement.setInt(1, 5);
			
			ResultSet resultSet = preparedStatement.executeQuery() ;
			
			if(resultSet.next()) {
			//	int id = resultSet.getInt(1) ;
				Blob blob = resultSet.getBlob(4) ;
				
				byte[] bs = blob.getBytes(1, (int) blob.length()) ;
				
				FileOutputStream fileOutputStream = new FileOutputStream("C:\\Users\\ck\\Pictures\\Screenshots\\dowload1.PNG") ;
				
				fileOutputStream.write(bs);
				fileOutputStream.close();
			System.out.println("Done");
			}
			
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
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
