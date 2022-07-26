package com_dao;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.resource.DbResource;

import com_bean.Employee;

public class EmployeeDao {
	public int insertEmployee(Employee emp) {
        try {
        	Connection con = DbResource.getDbConnection();
//        	Class.forName("com.mysql.cj.jdbc.Driver");
//        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/maybankdb?useSSL=false","root","Simplilearn");
			PreparedStatement pstmt = con.prepareStatement("insert into employee values(?,?,?)");
			pstmt.setInt(1, emp.getId());
			pstmt.setString(2, emp.getName());
			pstmt.setFloat(3, emp.getSalary());
			int res = pstmt.executeUpdate();
			return res;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
         }

	public int updateEmployee(Employee emp) {
        try {
        	Connection con = DbResource.getDbConnection();
//        	Class.forName("com.mysql.cj.jdbc.Driver");
//        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/maybankdb?useSSL=false","root","Simplilearn");
   		    PreparedStatement pstmt = con.prepareStatement("update employee set salary =? where id =?");			
			pstmt.setFloat(1, emp.getSalary());
			pstmt.setInt(2, emp.getId());
			int res = pstmt.executeUpdate();
			return res;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
	} 
	
	public int deleteEmployee(int id) {
        try {
        	Connection con = DbResource.getDbConnection();
//        	Class.forName("com.mysql.cj.jdbc.Driver");
//        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/maybankdb?useSSL=false","root","Simplilearn");
			PreparedStatement pstmt = con.prepareStatement("delete from employee where id =?");			
			pstmt.setInt(1,id);
			int res = pstmt.executeUpdate();
			return res;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
	}   
	
	public List<Employee> findAllEmployee() {
        List<Employee> listOfEmp = new ArrayList<>();
        try {
        	Connection con = DbResource.getDbConnection();
//Class.forName("com.mysql.cj.jdbc.Driver");
//Connection con =DriverManager.getConnection("jdbc:mysql://localhost:3306/maybankdb?useSSL=false", "root", "Simplilearn");
PreparedStatement pstmt = con.prepareStatement("select * from employee");
ResultSet rs = pstmt.executeQuery();
    while(rs.next()) {
        Employee emp = new Employee();                // convert query into objects. 
        emp.setId(rs.getInt(1));
        emp.setName(rs.getString(2));
        emp.setSalary(rs.getFloat(3));
        listOfEmp.add(emp);
        }
        } catch (Exception e) {
            System.out.println(e);
        }
        return listOfEmp;
    }  
}
