package com.service;

import java.util.List;

import com.dao.EmployeeDao;
import com.entity.Employee;

public class EmployeeService {
	EmployeeDao ed = new EmployeeDao();
	
	public 	String storeEmployee(Employee emp) {
		
		if(emp.getSalary()<12000) {
			return "Salary must be > 12000";
		}else if(ed.storeEmployee(emp)>0) {
			return "record stored successfully";
		}else {
			return "Record did not store";
		}
	}
	
	public String updateEmployeeSalary(Employee emp) {
        if(ed.updateEmployeeSalary(emp)>0) {
            return "Record updated successfully";
        }else {
            return "Record not present";
        }
    }

	public String deleteEmployeeInfo(int id) {
        if(ed.deleteEmployeeInfo(id)>0) {
            return "Record deleted successfully";
        }else {
            return "Record not present";
        }
    }
	

    public String findEmployeeById(int id) {
            Employee e = ed.findEmployeeById(id);
            if(e==null) {
                return "No record found";
            }else {
                String msg = "id is "+e.getId()+" Name is "+e.getName()+" Salary is "+e.getSalary();
                return msg;
            }
    }
    
    public List<Employee> findAllEmployee() {
		return ed.findAllEmployee();
	}
    
}
