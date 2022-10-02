package com.app.Main;

import java.util.Scanner;

import com.app.usecases.EmployeeChangePasswordUseCase;
import com.app.usecases.EmployeeComplaintListUseCase;
import com.app.usecases.EngineerChangePasswordUsecase;
import com.app.usecases.EngineerComplaintList;
import com.app.usecases.RegisterComplaintUseCase;
import com.app.usecases.UpdateStatusUseCase;

public class EmployeeOptins {
	public static void main(String[] args) {
		System.out.println("Welcom Employee");
		System.out.println("Select Options to Continue");
		System.out.println("1.Register new Complaint");
		System.out.println("2.Check Your Complaints");
		System.out.println("3.Change Password");
		
		
		Scanner sc = new Scanner(System.in);
		
		int choice = sc.nextInt();
		
		switch(choice) {
			case 1:
				RegisterComplaintUseCase.main(args);
			case 2:
				EmployeeComplaintListUseCase.main(args);
			case 3:
				EmployeeChangePasswordUseCase.main(args);
			
			default:
				System.out.println("Invalid Input");
				Main.main(args);
		}

	}

}
