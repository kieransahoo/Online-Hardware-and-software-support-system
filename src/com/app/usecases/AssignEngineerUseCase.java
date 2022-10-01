package com.app.usecases;

import java.util.Scanner;

import com.app.dao.HODDao;
import com.app.dao.HODDaoImpl;
import com.app.exceptions.ComplaintException;
import com.app.exceptions.EngineerException;

public class AssignEngineerUseCase {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Complaint ID : ");
		int complaintID = sc.nextInt();
		
		System.out.println("Enter Engineer ID : ");
		int engineerId = sc.nextInt();
		
		HODDao dao = new HODDaoImpl();
		
		try {
			dao.assignComplaintToEngineer(complaintID, engineerId);
			System.out.println("Complaint Assigned Successfully");
		} catch (EngineerException e) {
			
			e.printStackTrace();
			
		} catch (ComplaintException e) {
			
			e.printStackTrace();
		}
	}

}
