package com.app.usecases;

import java.util.Scanner;

import com.app.bean.Employee;
import com.app.bean.Engineer;
import com.app.dao.EmployeeDao;
import com.app.dao.EmployeeDaoImpl;
import com.app.dao.EngineerDao;
import com.app.dao.EngineerDaoImpl;

public class RegisterEngineer {

	public static void main(String[] args) {
Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Engineer Name : ");
		String engname = sc.next();
		
		
		System.out.println("Enter Employee Email : ");
		String engemail = sc.next();
		
		System.out.println("Enter Employee Password : ");
		String engpassword = sc.next();
		
		EngineerDao dao = new EngineerDaoImpl();
		

		Engineer engineer = new Engineer();
		
		engineer.setEngname(engname);;
		engineer.setEngemail(engemail);;
		engineer.setEngpassword(engpassword);;
		
		String result = dao.registerEngineer(engineer);
		
		System.out.println(result);

	}

}
