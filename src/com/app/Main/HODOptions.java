package com.app.Main;

import java.util.Scanner;

import com.app.usecases.AssignEngineerUseCase;
import com.app.usecases.DeleteEngineerUseCase;
import com.app.usecases.GetAllComplaintListUseCase;
import com.app.usecases.GetAllEngineerListUseCase;
import com.app.usecases.RegisterEngineer;

public class HODOptions {

	public static void main(String[] args) {
		
		System.out.println("Welcom HOD");
		System.out.println("Select Options to Continue");
		System.out.println("1.Register New Engineer");
		System.out.println("2.See List of All Engineer");
		System.out.println("3.Delete Engineer");
		System.out.println("4.See All Complaints");
		System.out.println("5.Assign Engineer to Complaint");
		
		Scanner sc = new Scanner(System.in);
		
		int choice = sc.nextInt();
		
		switch(choice) {
			case 1:
				RegisterEngineer.main(args);
			case 2:
				GetAllEngineerListUseCase.main(args);
			case 3:
				DeleteEngineerUseCase.main(args);
			case 4:
				GetAllComplaintListUseCase.main(args);
			case 5:
				AssignEngineerUseCase.main(args);
			default:
				System.out.println("Invalid Input");
				Main.main(args);
		}

	}

}
