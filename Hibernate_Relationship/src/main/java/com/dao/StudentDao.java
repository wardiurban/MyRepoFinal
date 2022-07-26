package com.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.bean.Student;
import com.bean.Trainer;

public class StudentDao {
	
	public int storeStudentInfo(Student tr) {
        try {
            Configuration con = new Configuration();
            con.configure("hibernate.cfg.xml");
            SessionFactory sf  = con.buildSessionFactory();
            Session session = sf.openSession();
            Transaction tran = session.getTransaction();
            tran.begin();
                session.save(tr);
            tran.commit();
            return 1;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
	}
}
