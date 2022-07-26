package com.main;

import java.util.Scanner;

import com.service.EmployeeService;

import com_bean.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class Appl {

	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//	    System.out.println("enter the id");
//	    int id = sc.nextInt();
//	    System.out.println("enter the name");
//	    String name = sc.next();
//	    System.out.println("enter the salary");
//	    float salary = sc.nextFloat();
//	    Employee emp = new Employee();
//	    emp.setId(id);
//	    emp.setName(name);
//	    emp.setSalary(salary);
//	    EmployeeService es = new EmployeeService();
//	    String res = es.storeEmployee(emp);
//	    System.out.println(res);
//	}

			Scanner sc = new Scanner(System.in);
			String con="";
			int id;
			String name;
			float salary;
			String res;
			EmployeeService es = new EmployeeService();
			do {
					System.out.println("1:Add 2: Update 3:Delete 4:Retrieve");
					System.out.println("Enter your choice");
					int choice = sc.nextInt();
					switch(choice) {
					case 1:	System.out.println("Enter the id");
					        id = sc.nextInt();
					        System.out.println("Enter the name");
					        name = sc.next();
					        System.out.println("Enter the salary");
					        salary = sc.nextFloat();
					        Employee emp = new Employee();
					        emp.setId(id);
					        emp.setName(name);
					        emp.setSalary(salary);
					        res = es.storeEmployee(emp);
					        System.out.println(res);
							break;
					case 2:  System.out.println("Enter the id ");
					         id = sc.nextInt();
					         System.out.println("Enter the salary");
					         salary = sc.nextFloat();
					         Employee emp1 = new Employee();
					         emp1.setId(id);
					         emp1.setSalary(salary);
					         res = es.updateEmployee(emp1);
					         System.out.println(res);
							break;
					case 3: System.out.println("Enter the id to delete the record");
					        id = sc.nextInt();
					        res = es.deleteEmloyee(id);
					        System.out.println(res);
					        break;
					default : System.out.println("wrong choice");
					         break;
			        case 4: List<Employee> listOfEmp = es.getAllEmployee();
			                    Iterator<Employee> li = listOfEmp.iterator();
			                     while(li.hasNext()) {
			                         Employee e = li.next();
			                         System.out.println("Id is "+e.getId()+" Name is "+e.getName()+" Salary is "+e.getSalary());
			                     }
			                     break;
					}
					System.out.println("do you want to continue?(y/n)");
					con = sc.next();
			}while(con.equalsIgnoreCase("y"));
			System.out.println("Thank you Visit Again!");
			
	}
}
