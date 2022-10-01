package com.app.usecases;

import java.util.Scanner;

import com.app.dao.EngineerDao;
import com.app.dao.EngineerDaoImpl;
import com.app.exceptions.ComplaintException;

public class UpdateStatusUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Complaint ID to Update");
		int compId = sc.nextInt();
		
		System.out.println("Enter New Status of Complaint");
		String status = sc.next();
		
		EngineerDao dao = new EngineerDaoImpl();
		
		try {
			dao.UpdateAssignedComplaintStatus(compId, status);
			System.out.println("Status Updated Successfully");
		} catch (ComplaintException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
