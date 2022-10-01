package com.app.usecases;

import java.util.List;
import java.util.Scanner;

import com.app.bean.Complaint;
import com.app.dao.EmployeeDao;
import com.app.dao.EmployeeDaoImpl;
import com.app.exceptions.EmployeeException;

public class EmployeeComplaintListUseCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your EmployeeId : ");
		int id = sc.nextInt();
		
		EmployeeDao dao= new EmployeeDaoImpl();
		
		try {
			List<Complaint> list = dao.ComplaintList(id);
			list.forEach(c -> System.out.println(c));
			
		}catch(EmployeeException e) {
			e.printStackTrace();
		}
		
		

	}

}
