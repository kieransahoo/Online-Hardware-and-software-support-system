package com.app.usecases;

import java.util.List;

import com.app.Main.Main;
import com.app.bean.Engineer;
import com.app.dao.HODDao;
import com.app.dao.HODDaoImpl;
import com.app.exceptions.EngineerException;


public class GetAllEngineerListUseCase {

	public static void main(String[] args) {
		
		HODDao dao = new HODDaoImpl();
		
		try {
			
			List <Engineer> engineers = dao.getAllEngineerDetails();
			
			engineers.forEach(e -> System.out.println(e));
			
			
		} catch (EngineerException e) {
			
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}

	}

}
