package com.app.usecases;

import java.util.List;
import java.util.Scanner;

import com.app.bean.Complaint;
import com.app.dao.EmployeeDao;
import com.app.dao.EmployeeDaoImpl;
import com.app.dao.EngineerDao;
import com.app.dao.EngineerDaoImpl;
import com.app.exceptions.EmployeeException;
import com.app.exceptions.EngineerException;

public class EngineerComplaintList {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter Your EngineerId : ");
		int id = sc.nextInt();
		
		EngineerDao dao= new EngineerDaoImpl();
		
		
			List<Complaint> list;
			try {
				list = dao.ComplaintList(id);
				list.forEach(c -> System.out.println(c));
			} catch (EngineerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		

	}

}
