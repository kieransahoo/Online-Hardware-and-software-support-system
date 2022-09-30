package com.app.usecases;

import java.util.Scanner;

import com.app.bean.Employee;
import com.app.dao.EmployeeDao;
import com.app.dao.EmployeeDaoImpl;


public class RegisterEmployee {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee Name : ");
		String empname = sc.next();
		
		
		System.out.println("Enter Employee Email : ");
		String empemail = sc.next();
		
		System.out.println("Enter Employee Password : ");
		String emppassword = sc.next();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		

		Employee employee = new Employee();
		
		employee.setEmpname(empname);
		employee.setEmpemail(empemail);
		employee.setEmppassword(emppassword);
		
		String result = dao.registerEmployee(employee);
		
		System.out.println(result);

	}

}
