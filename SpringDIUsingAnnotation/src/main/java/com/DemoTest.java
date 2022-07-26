package com;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
//		Employee emp = (Employee) ac.getBean("employee");
//		
//		//System.out.println(emp.getId());
//		//System.out.println(emp.getName());
//        //System.out.println(emp.getSalary()); 
//		
//		System.out.println(emp); //automatically call go string method
//		emp.setId(100);
//		emp.setName("Ahmad");
//		emp.setSalary(1000);
//		System.out.println(emp);
		
		AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(MyConfiguration.class);
		Employee emp = (Employee)ac.getBean("employee");
		System.out.println(emp);
	}

}
