package com.app.usecases;

import java.util.Scanner;

import com.app.dao.EmployeeDao;
import com.app.dao.EmployeeDaoImpl;
import com.app.exceptions.EmployeeException;



public class EmployeeLoginUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Employee Email : ");
		String email = sc.next();
		
		System.out.println("Enter Employee password : ");
		String password = sc.next();

		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			dao.EmployeeLogin(email, password);
			
			System.out.println("Welcome Employee !");
		} catch (EmployeeException e) {
			System.out.println(e.getMessage());
		}

	}

}
