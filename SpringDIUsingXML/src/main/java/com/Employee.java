package com;

public class Employee {
	
	private int id;
	private String name;
	private float salary;
	private Address add;
	
	Employee (){
		System.out.println("Object created....");
	}
	
	
	public Employee(int id, String name, float salary) {
		super();
		System.out.println("Object created with parameter....");
		this.id = id;
		this.name = name;
		this.salary = salary;
		
	}


	public void displayEmployee () {
		System.out.println("This is Simple Method");
				
		System.out.println("id is "+id);
		System.out.println("name is "+name);
		System.out.println("salary "+salary);
		
		
		System.out.println("city "+add.getCity());
		System.out.println("state "+add.getState());
		
	}
	
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public float getSalary() {
		return salary;
	}


	public void setSalary(float salary) {
		this.salary = salary;
	}


	public Address getAdd() {
		return add;
	}


	public void setAdd(Address add) {
		this.add = add;
	}


	
}
