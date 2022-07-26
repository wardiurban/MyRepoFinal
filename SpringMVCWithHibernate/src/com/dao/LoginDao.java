package com.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.bean.Login;

@Repository
public class LoginDao {
	
	@Autowired
	SessionFactory sf;
	
	public int signIn(Login ll) {
        Session session = sf.openSession();
        Query qry    = session.createQuery("select l from Login l where l.email = :email and l.password = :password");
        qry.setParameter("email", ll.getEmail());
        qry.setParameter("password", ll.getPassword());
        List<Login> listOfLogin = qry.list();
        return listOfLogin.size();
    }
	
	
	public int signUp(Login ll) {
		try {
		Session session = sf.openSession();
		Transaction tran = session.getTransaction();
		tran.begin();
			session.save(ll);
		tran.commit();
		return 1;
		}catch(Exception e) {
			System.out.println(e);
			return 0;
		}
	}	
	
}



