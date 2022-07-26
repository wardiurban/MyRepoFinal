package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.Login;

@Repository
public class LoginDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	public List<Login> signIn(Login ll) {
		try {
			MyRowMapper mm  = new MyRowMapper();		
			return jdbcTemplate.query("select * from login where email = ? and password = ?", 
					new Object[] {ll.getEmail(),ll.getPassword()}, mm);
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
	public int signUp(Login ll) {
			try {
				return jdbcTemplate.update("insert into login values(?,?)", ll.getEmail(),ll.getPassword());	// insert , delete and update 
			} catch (Exception e) {
				System.out.println(e);
			}
			return 0;
	}
}
class MyRowMapper implements RowMapper<Login>{
	@Override
	public Login mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Login ll = new Login();
		ll.setEmail(rs.getString(1));
		ll.setPassword(rs.getString(2));
		return ll;
	}
}