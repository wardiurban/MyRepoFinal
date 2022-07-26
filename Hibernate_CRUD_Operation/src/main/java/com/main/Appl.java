package com.main;

import java.util.List;
import java.util.Iterator;
import java.util.Scanner;
import com.entity.Employee;
import com.service.EmployeeService;

public class Appl {

	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
        EmployeeService es = new EmployeeService();
        int id;
        String name;
        float salary;
        String con="";
        int choice;
        String res;
        do {
            System.out.println("1: Add Employee 2:Update Employee 3:Delete Employee 4:Search Employee 5:Find All Employee ");
            System.out.println("Plz enter your choice");
            choice = sc.nextInt();
            switch (choice) {
            case 1: System.out.println("Enter the id");
                     id = sc.nextInt();
                     System.out.println("Enter the name");
                     name = sc.next();
                     System.out.println("Enter the salary");
                     salary = sc.nextFloat();
                     Employee e1 = new Employee(id, name, salary);
                     res = es.storeEmployee(e1);
                     System.out.println(res);
                break;
            case 2: System.out.println("Enter the id");
            id = sc.nextInt();
            System.out.println("Enter the salary");
            salary = sc.nextFloat();
            Employee e2 = new Employee();
            e2.setId(id);
            e2.setSalary(salary);
            res = es.updateEmployeeSalary(e2);
            System.out.println(res);
            break;
            case 3: System.out.println("Enter the id");
            id = sc.nextInt();
            res = es.deleteEmployeeInfo(id);
            System.out.println(res);
            break;
            case 4: System.out.println("Plz enter the id to search the employee by id");
            id = sc.nextInt();
            res = es.findEmployeeById(id);
            System.out.println(res);
            break;
            case 5: List<Employee> listOfEmp = es.findAllEmployee();
	        Iterator<Employee> li = listOfEmp.iterator();
	        while(li.hasNext()) {
	        	Employee e= li.next();
	        	System.out.println("id is "+e.getId()+" Name is "+e.getName()+" Salary is "+e.getSalary());
	        }
	        break;
            default:System.out.println("Wrong choice");
                break;
            }
            System.out.println("Do you want to continue (y/n)");
            con = sc.next();
        } while (con.equalsIgnoreCase("y"));
        System.out.println("Thank You!");

	}

}
