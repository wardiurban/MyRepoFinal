package com.dao;

import org.hibernate.cfg.*;

import java.util.List;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;

import com.entity.Employee;

public class EmployeeDao {
	
	public int storeEmployee(Employee emp) {
		try {
			Configuration con = new Configuration();
			con.configure("hibernate.cfg.xml");
			SessionFactory sf = con.buildSessionFactory();
			Session session = sf.openSession();
			Transaction tran = session.getTransaction();
			tran.begin();
			session.save(emp);
			tran.commit();
			return 1;
		} catch (Exception e) {
			System.out.println(e);
			return 0;
		}
	}

	public int updateEmployeeSalary(Employee emp) {
        
        Configuration con  = new Configuration();
        con.configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();    // it like a connecton reference. 
        Session session = sf.openSession();            // it is like a Statement and PreparedStatement 
        Transaction tran = session.getTransaction();
                    
        Employee e=    session.get(Employee.class, emp.getId());
        if(e==null) {
            return 0;
        }else {
                tran.begin();
                float newSalary = emp.getSalary();
                e.setSalary(newSalary);            //updated new salary     
                    session.update(e);                    // update query executed internally 
                tran.commit();
                return 1;
        }
}
	
public int deleteEmployeeInfo(int id) {
        
        Configuration con  = new Configuration();
        con.configure("hibernate.cfg.xml");
        SessionFactory sf = con.buildSessionFactory();    // it like a connecton reference. 
        Session session = sf.openSession();            // it is like a Statement and PreparedStatement 
        Transaction tran = session.getTransaction();
                    
        Employee e=    session.get(Employee.class, id);
        if(e==null) {
            return 0;
        }else {
                tran.begin();
                session.delete(e);                     // delete query execute internally 
                tran.commit();
                return 1;
        }
    }

    public Employee findEmployeeById(int id) {
    
    Configuration con  = new Configuration();
    con.configure("hibernate.cfg.xml");
    SessionFactory sf = con.buildSessionFactory();    // it like a connecton reference. 
    Session session = sf.openSession();            // it is like a Statement and PreparedStatement             
    Employee e=    session.get(Employee.class, id);
    return e;
     }
    
    public List<Employee> findAllEmployee() {
		Configuration con  = new Configuration();
		con.configure("hibernate.cfg.xml");
		SessionFactory sf = con.buildSessionFactory();	// it like a connecton reference. 
		Session session = sf.openSession();	
	    //Query qry= session.createQuery("select emp from Employee emp");
//	    Query qry= session.createQuery("select emp from Employee emp where emp.id = 6");
		Query qry= session.createQuery("select emp from Employee emp where emp.salary > 15000");
	    List<Employee> listOfEmp = qry.list();
	    return listOfEmp;
	}
}
