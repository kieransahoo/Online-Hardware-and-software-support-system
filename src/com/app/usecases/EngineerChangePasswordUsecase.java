package com.app.usecases;

import java.util.Scanner;

import com.app.dao.EngineerDao;
import com.app.dao.EngineerDaoImpl;
import com.app.exceptions.EngineerException;

public class EngineerChangePasswordUsecase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your Email");
		String email = sc.next();
		
		System.out.println("Enter new password");
		String newpassword = sc.next();
		
		EngineerDao dao = new EngineerDaoImpl();
		
		try {
			dao.ChangePassword(email, newpassword);
			System.out.println("Changed Successfully");
		}catch(EngineerException e) {
			e.printStackTrace();
		}

	}

}
