package com.main;

import java.util.ArrayList;

import com.bean.Student;
import com.bean.Trainer;
import com.service.StudentService;
import com.service.TrainerService;

public class ApplMain {

	public static void main(String[] args) {
		 // Insert Trainer Record 
//		TrainerService ts = new TrainerService();
//        Trainer t1 = new Trainer();
//        t1.setTid(3);
//        t1.setTname("Ramesh");
//        t1.setTech("Angular");
//        String res = ts.storeTrainerInfo(t1);
//        System.out.println(res);
		
		//Insert Student Record
		
//	  StudentService ss = new StudentService();
//      Student s1 = new Student();
//      s1.setSid(3);
//      s1.setSname("Abu");
//      s1.setAge(25);
//      s1.setTsid(2);
//      String res = ss.storeStudentInfo(s1);
//      System.out.println(res);
		
//      Store Trainer and Student details together using cascade property in Dao
      Trainer t1 = new Trainer();
      t1.setTid(5);
      t1.setTname("Balaji");
      t1.setTech("ML");
      
      Student s1 = new Student();
      s1.setSid(107);
      s1.setSname("Oeeta");
      s1.setAge(37);
      s1.setTsid(1);
      
      Student s2 = new Student();
      s2.setSid(108);
      s2.setSname("Peeta");
      s2.setAge(39);
      s2.setTsid(5);
      
      ArrayList<Student> listOfStd = new ArrayList<>();
      listOfStd.add(s1);
      listOfStd.add(s2);
      
      t1.setListOfStd(listOfStd);
      TrainerService ts = new TrainerService();
      String res = ts.storeTrainerInfo(t1);
      System.out.println(res);
		

	}

}
