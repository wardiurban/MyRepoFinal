package com;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;

public class DemoTest {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver loaded successfully");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/maybankdb?useSSL=false","root","Simplilearn");
//			System.out.println("Connected Successfully");
//			PreparedStatement pstmt = con.prepareStatement("insert employee values(?,?,?)");
//			pstmt.setInt(1,6);
//			pstmt.setString(2,"Wardi");
//			pstmt.setFloat(3, 3750);
//			
//			int res = pstmt.executeUpdate();
//			if(res>0) {
//				System.out.println("Record insert successfully");
//			}
			
//			PreparedStatement pstmt = con.prepareStatement("update employee set salary = ? where id = ?");
//			pstmt.setFloat(1, 3755);
//			pstmt.setInt(2,1);
//			
//			int res = pstmt.executeUpdate();
//			if(res>0) {
//				System.out.println("Record updated");
//			}else{
//			    System.out.println("Record not found");
//			}
			
//			PreparedStatement pstmt = con.prepareStatement("delete from employee where id = ?");
//			pstmt.setInt(1,2);
//			
//			int res = pstmt.executeUpdate();
//			if(res>0) {
//				System.out.println("Record deleted");
//			}else{
//			    System.out.println("Record not found");
//			}
		
			PreparedStatement pstmt = con.prepareStatement("select * from employee");
	        ResultSet rs =pstmt.executeQuery();
	        while(rs.next()) {
	            System.out.println(" Id is "+rs.getInt(1)+" Name is "+rs.getString(2)+" Salary is "+rs.getFloat(3));
	        }    
			
			
		} catch (Exception e) {
			System.out.println(e);
			}

	}

}
