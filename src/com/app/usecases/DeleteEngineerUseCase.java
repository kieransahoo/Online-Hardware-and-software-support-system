package com.app.usecases;

import java.util.Scanner;

import com.app.dao.HODDao;
import com.app.dao.HODDaoImpl;
import com.app.exceptions.EngineerException;

public class DeleteEngineerUseCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter EngineerId : ");
		int id = sc.nextInt();
		
		HODDao dao = new HODDaoImpl();
		
		
		try {
			dao.deleteEngineer(id);
			System.out.println("Removed Succesfully!");
		} catch (EngineerException e) {
			e.printStackTrace();
		}
			
		

	}

}
