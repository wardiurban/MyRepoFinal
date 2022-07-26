package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Employee emp = new Employee;
		//emp.displayEmployee();
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		
//		Employee e1 = (Employee)ac.getBean("emp1");		// empty constructor (singleton)
//		e1.displayEmployee();
//		
//		Employee e3 = (Employee)ac.getBean("emp1");		// empty constructor (singleton)
//		e3.displayEmployee();
//		
//		Employee e2 = (Employee)ac.getBean("emp2");		// empty constructor (prototype)
//		e2.displayEmployee();
//		
//		Employee e4 = (Employee)ac.getBean("emp2");		// empty construtor (prototype)
//		e4.displayEmployee();
		
//		Employee e5 = (Employee)ac.getBean("emp3");		// parameter constructor (singletone)
//		e5.displayEmployee();
		
//		Employee e6= (Employee)ac.getBean("emp4");
//		e6.displayEmployee();
		
		Employee e7 = (Employee)ac.getBean("employee");
		e7.displayEmployee();
//		
//		Address a1 = (Address)ac.getBean("add");
//		System.out.println("City is "+a1.getCity());
//		System.out.println("State is "+a1.getState());
			
	}

}
