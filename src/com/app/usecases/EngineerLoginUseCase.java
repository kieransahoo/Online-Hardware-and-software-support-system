package com.app.usecases;

import java.util.Scanner;

import com.app.dao.EngineerDao;
import com.app.dao.EngineerDaoImpl;
import com.app.exceptions.EngineerException;



public class EngineerLoginUseCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Engineer Email : ");
		String email = sc.next();
		
		System.out.println("Enter Engineer password : ");
		String password = sc.next();

		
		EngineerDao dao = new EngineerDaoImpl();
		
		try {
			dao.EngineerLogin(email, password);
			
			System.out.println("Welcome Engineer !");
		} catch (EngineerException e) {
			System.out.println(e.getMessage());
		}
	}

}
