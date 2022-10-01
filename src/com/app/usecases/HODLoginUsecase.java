package com.app.usecases;

import java.util.Scanner;

import com.app.dao.HODDao;
import com.app.dao.HODDaoImpl;
import com.app.exceptions.HODException;


public class HODLoginUsecase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter HOD Username : ");
		String username = sc.next();
		
		System.out.println("Enter HOD password : ");
		String password = sc.next();

		HODDao dao = new HODDaoImpl();
		
		try {
			dao.loginHOD(username, password);
			
			System.out.println("Welcome HOD ");
		} catch (HODException e) {
			System.out.println(e.getMessage());
		}
		

	}

}
