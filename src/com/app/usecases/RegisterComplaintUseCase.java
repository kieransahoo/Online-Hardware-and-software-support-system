package com.app.usecases;

import java.util.Scanner;

import com.app.bean.Complaint;
import com.app.dao.EmployeeDao;
import com.app.dao.EmployeeDaoImpl;

public class RegisterComplaintUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Category(Software/hardware) : ");
		String category = sc.next();
		
		
		System.out.println("Status Pending");
		String status = "Pending";
		
		System.out.println("Enter Your EmployeeID :  ");
		int empId = sc.nextInt();
		
		EmployeeDao dao = new EmployeeDaoImpl();
		
		Complaint complaint = new Complaint();
		complaint.setCategory(category);
		complaint.setStatus(status);
		complaint.setEmpid(empId);
		
		String result = dao.registerComplaint(complaint);
		
		System.out.println(result);
		
	}

}
