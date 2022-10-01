package com.app.usecases;

import java.util.List;

import com.app.bean.Complaint;
import com.app.dao.HODDao;
import com.app.dao.HODDaoImpl;
import com.app.exceptions.ComplaintException;



public class GetAllComplaintListUseCase {

	public static void main(String[] args) {
		
		HODDao dao = new HODDaoImpl();
		
		try {
			
			List <Complaint> complaints = dao.getAllComplaintList();
			
			complaints.forEach(e -> System.out.println(e));
			
			
		} catch (ComplaintException e) {
			
			System.out.println(e.getMessage());
		}
	}

}
