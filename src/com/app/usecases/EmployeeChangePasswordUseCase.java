package com.app.usecases;

import java.util.Scanner;

import com.app.dao.EmployeeDao;
import com.app.dao.EmployeeDaoImpl;
import com.app.exceptions.EmployeeException;

public class EmployeeChangePasswordUseCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your Email");
		String email = sc.next();
		
		System.out.println("Enter new password");
		String newpassword = sc.next();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		try {
			dao.ChangePassword(email, newpassword);
			System.out.println("Changed Successfully");
			
		}catch(EmployeeException e) {
			e.printStackTrace();
		}
		
	}

}
