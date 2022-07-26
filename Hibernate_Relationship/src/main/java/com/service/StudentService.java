package com.service;

import com.bean.Student;
import com.dao.StudentDao;

public class StudentService {
StudentDao sd = new StudentDao();
    
    public String storeStudentInfo(Student st) {
        
        if(sd.storeStudentInfo(st)>0) {
            return "Student Record stored";
        }else {
            return "Student record didn't store";
        }
    }
	

}
