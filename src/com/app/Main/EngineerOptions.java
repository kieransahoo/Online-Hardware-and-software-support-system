package com.app.Main;

import java.util.Scanner;

import com.app.usecases.AssignEngineerUseCase;
import com.app.usecases.DeleteEngineerUseCase;
import com.app.usecases.EngineerChangePasswordUsecase;
import com.app.usecases.EngineerComplaintList;
import com.app.usecases.GetAllComplaintListUseCase;
import com.app.usecases.GetAllEngineerListUseCase;
import com.app.usecases.RegisterEngineer;
import com.app.usecases.UpdateStatusUseCase;

public class EngineerOptions {

	public static void main(String[] args) {
		System.out.println("Welcom Engineer");
		System.out.println("Select Options to Continue");
		System.out.println("1.Check Assigned Complaint");
		System.out.println("2.Update Assign Complaint");
		System.out.println("3.Change Password");
		
		
		Scanner sc = new Scanner(System.in);
		
		int choice = sc.nextInt();
		
		switch(choice) {
			case 1:
				EngineerComplaintList.main(args);
			case 2:
				UpdateStatusUseCase.main(args);
			case 3:
				EngineerChangePasswordUsecase.main(args);
			
			default:
				System.out.println("Invalid Input");
				Main.main(args);
		}

	}

}
